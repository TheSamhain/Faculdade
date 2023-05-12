import AsyncStorage from '@react-native-async-storage/async-storage';
import React, { useEffect, useState } from 'react';
import { View, StyleSheet, TextInput, Button, Alert, BackHandler, Text } from 'react-native';
import { Cores } from '../config/style';
import { firebaseDB } from '../config/db.firebase';
import Loading from '../components/Loading';
import moment from 'moment';

const Key = ({ navigation }) => {
    const [keyCode, setKeyCode] = useState('');
    const [wait, setWait] = useState(true);

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

    const login = async () => {
        try {
            let idUser = await AsyncStorage.getItem('userKey');

            if (!idUser)
                return

            let userRef = firebaseDB.ref("usuarios/" + idUser),
            user = (await userRef.once('value')).val();

            if (!user)
                throw 'Chave não encontrada no sistema';

            if ((!user.funcionario) || (!user.idFuncionario))
                throw 'Usuário não é um funcionário';


            if (!user.funcionario.habilitado)
                throw 'Funcionário não habilitado';

            let onibus = (await firebaseDB.ref("onibus").orderByChild("conduzindo").equalTo(idUser).once('value')).val();

            userRef.child('funcionario').update({ ultimoAcesso: moment().format('DD/MM/YYYY HH:mm:ss')});

            if (!onibus)
                navigation.navigate('SelectBus', { idUser });
            else {
                const idBus = Object.keys(onibus)[0];
                onibus = onibus[idBus];

                if (!onibus.linha)
                    navigation.navigate('SelectLine', { idBus });
                else
                    navigation.navigate('ChangeBL', { idBus, idLine: onibus.linha });
            }

        } catch (err) {
            console.log(err);

            Alert.alert('Erro', err + '\nVerifique com a empresa onde trabalhar para resolver o problema');
            await AsyncStorage.removeItem('userKey');
        }
        finally {
            setWait(false);
        }
    }

    useEffect(() => {
        login();
    }, [])

    const entrar = () => {
        if (!keyCode) {
            Alert.alert('Insira a chave para entrar.')
            return;
        }

        setWait(true);

        firebaseDB.ref("usuarios").orderByChild('idFuncionario').equalTo(keyCode).once('value', (usuario) => {
            if(usuario.exists()){
                usuario = usuario.val();
                const chave = Object.keys(usuario)[0];
                AsyncStorage.setItem('userKey', chave).then(() => login())
            } else {
                Alert.alert('Erro', 'Chave inválida');
                setWait(false);
            }
        })

    }

    return (
        <View style={styles.page}>
            { (wait)
                ? <Loading />
                : <>
                    <TextInput
                        style={styles.input}
                        editable
                        placeholder="Insira sua chave"
                        maxLength={40}
                        value={keyCode}
                        onChangeText={(text) => setKeyCode(text.trim())}
                    />

                    <View style={styles.btnEntrar} >
                        <Button
                            title="Entrar"
                            color={Cores.default}
                            onPress={entrar} />
                    </View>
                </>
            }

        </View>
    );
}

const styles = StyleSheet.create({
    page: {
        flex: 1,
        flexDirection: 'column',
        alignItems: "center",
        justifyContent: "center"
    },
    input: {
        padding: 5,
        paddingLeft: 10,
        fontSize: 20,
        height: 40,
        backgroundColor: Cores.background_Light,
        borderWidth: 1,
        borderColor: Cores.default,
        width: "80%",
    },
    btnEntrar: {
        marginTop: 25,
        width: '80%'
    },
});


export default Key;