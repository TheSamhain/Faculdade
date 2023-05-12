import AsyncStorage from '@react-native-async-storage/async-storage';
import { StackActions } from '@react-navigation/native';
import React, { useEffect, useState } from 'react';
import { View, Text, Image, StyleSheet, Button, ScrollView, Switch } from 'react-native';

import PerfilLine from '../../components/PerfilLine';
import { firebaseDB } from '../../config/db.firebase';
import { Cores } from '../../config/style';

export default function Profile({ navigation, route }) {

  const
    { params } = route,
    { usuario } = params;

  const [mapaLimpo, setMapaLimpo] = useState(!!usuario.mapaLimpo);
  const mapaLimpoChange = () => {
    firebaseDB
      .ref("usuarios/" + params.idUser)
      .update({ mapaLimpo: !mapaLimpo });
    setMapaLimpo(previousState => !previousState);
  };

  let infos = [];

  for (const info in usuario.informacoes) {
    if(info != 'metadata'){
      infos.push(<PerfilLine label={`${info}`} content={usuario.informacoes[info]} key={info} />);
    }
  }

  return (
    <View style={styles.container}>
      <Image
        source={!!usuario.foto
          ? { uri: usuario.foto }
          : require('../../../assets/User.png')}
        style={styles.avatar}
      />

      <ScrollView style={styles.detailContainer}>
        {infos}
        {/* <PerfilLine
          label={`Mapa mais limpo`}
          content={<Switch onValueChange={mapaLimpoChange} value={mapaLimpo} />}
          key={'Mapa mais limpo'} /> */}
      </ScrollView>

      {/* <Button title="Editar" color={Cores.default} /> */}

      <View style={styles.btnSair} >
        <Button
          title="Desconectar"
          color={Cores.erro}
          onPress={() => {
            AsyncStorage.removeItem('userId').then(() => navigation.navigate('Login'));
          }} />
      </View>
    </View>
  );

}

const styles = StyleSheet.create({
  container: {
    padding: 15,
    display: 'flex',
    flexDirection: 'column',
    flex: 1
  },

  avatar: {
    height: 250,
    aspectRatio: 1,
    borderRadius: 1000,
    width: 200,
    alignSelf: 'center'
  },

  detailContainer: {
    width: 300,
    marginTop: 15,

  },

  btnSair: {
    marginTop: 25,
  },


});
