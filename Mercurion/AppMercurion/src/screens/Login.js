import LoginButton from '../components/LoginButton';
import React, { useEffect, useState } from 'react';
import { View, StyleSheet, Alert } from 'react-native';
import { useNavigation } from '@react-navigation/native';
import googleConfig from '../config/Google.logInAsync';
import * as Google from 'expo-google-app-auth';
import { firebaseDB } from '../config/db.firebase';
import Loading from '../components/Loading';
import AsyncStorage from '@react-native-async-storage/async-storage';
import * as Facebook from 'expo-facebook';
import { now } from '../utils';

import * as GoogleSignIn from 'expo-google-sign-in';


const Login = () => {
  const navigation = useNavigation();
  const [wait, setWait] = useState(true);

  useEffect(() => {
    AsyncStorage.getItem('userId').then(async (id) => {
      if (!!id) {
        const usuario = await firebaseDB.ref("usuarios/" + id).once('value');

        if (usuario.exists()) {
          firebaseDB.ref("usuarios/" + id).update({ ultimoAcesso: now() });

          navigation.navigate('Main', {
            idUser: id,
            usuario: usuario.val()
          });
        } else {
          await AsyncStorage.removeItem('userId');
        }
      }

      setWait(false);
    });
  }, [])

  const login = async (user) => {
    let
      userObj = (await firebaseDB.ref("usuarios").orderByChild("informacoes/email").equalTo(user.email).once('value')).val(),
      usuario = {},
      idUser;


    if (userObj == null) {
      usuario = {
        informacoes: {
          email: user.email,
          nome: user.name
        },
        ultimoAcesso: now(),
        habilitado: true,
        idConta: user.id,
        foto: user.photoUrl
      };

      let newUser = firebaseDB.ref("usuarios").push(usuario);
      idUser = (await newUser).key;

    } else {
      idUser = Object.keys(userObj)[0];
      usuario = userObj[idUser];

      firebaseDB.ref("usuarios/" + idUser).update({ ultimoAcesso: now() });
    }


    await AsyncStorage.setItem('userId', idUser);

    navigation.navigate('Main', {
      idUser,
      usuario
    });

  }

  const signInWithGoogle = async () => {
    setWait(true);

    try {
      if (!__DEV__) {
        await GoogleSignIn.askForPlayServicesAsync();
        const { type, user } = await GoogleSignIn.signInAsync();

        if (type === 'success') {
          await login(user);
        }

        return;
      }

      let { type, user } = await Google.logInAsync(googleConfig);

      if (type != "success") {
        type = "success";
        user = {
          email: "leon.np99@gmail.com",
          name: "Leonardo Noro Pereira",
          id: 123456,
          photoUrl: ""
        }

      }

      if (type === "success") {
        await login(user);
      } else {
        Alert.alert("Login cancelado");
      }
    } catch (e) {
      console.log(e);
      Alert.alert(`Erro ${e.message}`);
    } finally {
      setWait(false);
    }
  }

  const signInWithFacebook = async () => {
    setWait(true);

    const appId = '357549135938276';

    try {
      await Facebook.initializeAsync({ appId: appId, appName: 'Mercurion' });
      let {type, token} = await Facebook.logInWithReadPermissionsAsync({ permissions: ['public_profile', 'email'] });

      if(type === "success"){
        let resp = await fetch(`https://graph.facebook.com/me?access_token=${token}`);
        resp = await resp.json();

        console.log(resp);
      } else {
        Alert.alert("Login cancelado");
      }

    } catch (e) {
      console.log(e);
      Alert.alert(`Erro ${e.message}`);
    } finally {
      setWait(false);
    }

  }

  return (
    <View style={styles.page}>
      {(wait)
        ? <Loading />
        : <>
          <LoginButton key="GoogleButton" icon="md-logo-google" navigation title="Entrar com a conta do GOOGLE" onPress={signInWithGoogle} />
          {/* <LoginButton key="FacebookButton" icon="logo-facebook" navigation title="Entrar com FACEBOOK" onPress={signInWithFacebook} /> */}
        </>
      }

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

export default Login;