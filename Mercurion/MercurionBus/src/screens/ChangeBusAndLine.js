import DefaultButton from '../components/DefaultButton';
import React, { useEffect } from 'react';
import { View, StyleSheet, BackHandler, Alert } from 'react-native';
import AsyncStorage from '@react-native-async-storage/async-storage';
import * as Location from 'expo-location';
import * as TaskManager from 'expo-task-manager';
import * as Permissions from 'expo-permissions';
import { firebaseDB } from '../config/db.firebase';
import { useNavigation } from '@react-navigation/native';

const LOCATION_TRACKING = 'location-tracking';
var globalIdUser, globalIdBus, globalIdLine;

const ChangeBusAndLine = ({ navigation, route }) => {
  const
    { params } = route,
    { idBus, idLine } = params;

  // Impede de voltar para a tela anterior
  useEffect(() => {
    navigation.addListener('beforeRemove', (e) => {
      e.preventDefault();

      if (e.data.action.type != "NAVIGATE") {
        BackHandler.exitApp();
        return;
      }

      navigation.dispatch(e.data.action)
    })
  }, [navigation]);

  const startLocationTracking = async () => {
    let res = await Permissions.askAsync(Permissions.LOCATION);

    if (res.status !== 'granted' || res.permissions.location.scope !== 'always') {
      Alert.alert("Erro", "Permissão de acesso a localização negada!", [{
        text: "Tentar novamente",
        onPress: startLocationTracking
      }]);
    } else {
      await Location.startLocationUpdatesAsync(LOCATION_TRACKING, {
        accuracy: Location.Accuracy.Highest,
        timeInterval: 500,
        distanceInterval: 0,
        foregroundService: {
          notificationTitle: 'Mercurion BUS',
          notificationBody: 'Mercurion está pegando sua localização'
        },
        pausesUpdatesAutomatically: false,
      });

      const hasStarted = await Location.hasStartedLocationUpdatesAsync(LOCATION_TRACKING);

      if (!hasStarted) {
        Alert.alert("Erro", "Não foi possível pegar a localização do dispositivo", [{
          text: "Tentar novamente",
          onPress: startLocationTracking
        }]);
      }
    }
  };

  useEffect(() => {
    AsyncStorage.getItem('userKey').then(id => {
      if (!id) {
        Alert.alert('Usuário não autenticado, realize o login novamente');
        logOut();
        return;
      }

      globalIdUser = id;
      globalIdBus = idBus;
      globalIdLine = idLine;

      if (!globalIdBus) {
        Alert.alert('Ônibus não selecionado.');
        navigation.navigate("SelectBus", { idUser: id })
        return;
      }

      if (!globalIdLine) {
        Alert.alert('Linha não selecionada.');
        navigation.navigate("SelectLine", { idBus: bus })
        return;
      }

      startLocationTracking();

       const onibusRef = firebaseDB.ref(`onibus/${globalIdBus}`).child('conduzindo');
       onibusRef.on('value', async (snapshot) => {
        let conduzindo = snapshot.val();
    
        if ((conduzindo != globalIdUser) || !conduzindo) {
          onibusRef.off();
          Location.stopLocationUpdatesAsync(LOCATION_TRACKING);
          //Alert.alert('Ônibus não selecionado.');
          navigation.navigate("SelectBus", { idUser: id })
        }
      });
    });
  }, []);

  /**
   * Faz o LogOut limpando o id do usuário da memória
   */
  const logOut = () => {
    Location.stopLocationUpdatesAsync(LOCATION_TRACKING);
    firebaseDB.ref("onibus/" + idBus).update({ conduzindo: null, linha: null });
    firebaseDB.ref(`onibus/${globalIdBus}`).child('conduzindo').off();
    AsyncStorage.removeItem('userKey')
      .then(() => navigation.navigate("Key"));
  }

  const changeBus = () => {
    Location.stopLocationUpdatesAsync(LOCATION_TRACKING);
    firebaseDB.ref("onibus/" + idBus).update({ conduzindo: null, linha: null });
    firebaseDB.ref(`onibus/${globalIdBus}`).child('conduzindo').off();
    navigation.navigate("SelectBus", { globalIdUser })
  }

  const changeLine = () => {
    Location.stopLocationUpdatesAsync(LOCATION_TRACKING);
    firebaseDB.ref("onibus/" + idBus).update({ linha: null });
    navigation.navigate("SelectLine", { idBus })
  }

  return (
    <View style={styles.page}>
      <DefaultButton key="ChangeBusBtn" icon="bus-multiple" navigation title="Trocar ônibus" onPress={changeBus} />
      <DefaultButton key="ChangeLineBtn" icon="map-marker-path" navigation title="Trocar linha" onPress={changeLine} />
      <DefaultButton key="Disconect" icon="logout" navigation title="Desconectar" onPress={logOut} />
    </View>
  );
}

const styles = StyleSheet.create({
  page: {
    flex: 1,
    alignItems: "center",
    justifyContent: "center"
  }
});

TaskManager.defineTask(LOCATION_TRACKING, ({ data, error }) => {  
  if (error) {
    Alert.alert("Um erro ocorreu ao buscar a localização", error);
    console.log('LOCATION_TRACKING task ERROR:', error);
    return;
  }

  if (data) {
    const { locations } = data;
    let latitude = locations[0].coords.latitude;
    let longitude = locations[0].coords.longitude;

    if (!!globalIdBus) {
      firebaseDB.ref("onibus/" + globalIdBus).update({ atualLatLong: `${latitude}, ${longitude}` });
    }

  }
});

export default ChangeBusAndLine;