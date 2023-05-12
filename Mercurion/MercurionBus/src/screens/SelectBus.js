import AsyncStorage from '@react-native-async-storage/async-storage';
import React, { useEffect, useState } from 'react';
import { View, StyleSheet, Text, FlatList, Button, Alert, BackHandler } from 'react-native';
import ListItem from '../components/ListItem';
import Loading from '../components/Loading';
import { firebaseDB } from '../config/db.firebase';
import { Cores } from '../config/style';

const SelectBus = ({ navigation, route }) => {
    const
        [items, setItems] = useState([]),
        [wait, setWait] = useState(true),
        { params } = route,
        { idUser } = params;

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

    // Procura a lista de ônibus
    useEffect(() => {
        firebaseDB.ref("onibus").on('value', onibusList => {
            setItems([]);

            onibusList.forEach(onibus => {
                let key = onibus.key
                onibus = onibus.val();

                if (!onibus.conduzindo) {
                    onibus.id = key;
                    setItems(oldArray => [...oldArray, onibus]);
                }
            })

            setWait(false);
        })

    }, [])

    /**
     * Seleciona um ônibus
     * @param {Object} bus Item da lista para selecionar 
     */
    const chooseBus = (bus) => {
        setItems(arr =>
            arr.map(item => {
                item.selected = (item.id == bus.id);
                return item;
            })
        )
    }

    /**
     * Vai para a próxima tela se houver um ônibus selecionado
     */
    const next = () => {
        const selected = items.find(item => item.selected);

        if (!selected) {
            Alert.alert("Aviso", "Selecione um ônibus da lista para prosseguir");
            return;
        }

        setWait(true);

        // Retira 'conduzindo' e 'linha' dos ônibus que estão vinculados a este usuário
        firebaseDB.ref("onibus").orderByChild("conduzindo").equalTo(idUser).once('value').then(onibusLista => {
            onibusLista.forEach(onibus => {
                firebaseDB.ref("onibus/" + onibus.key).update({ conduzindo: null, linha: null });
            })
        });


        firebaseDB.ref("onibus/" + selected.id).update({ conduzindo: idUser }, (err) => {
            setWait(false);

            if (err) {
                Alert.alert('Não foi possível selecionar o ônibus\nTente novamente.');
            } else {
                navigation.navigate("SelectLine", { idBus: selected.id });
            }
        });
    }

    return (
        <View style={styles.page}>
            <Text style={styles.title}>Selecione um ônibus</Text>

            <FlatList
                style={styles.container}
                data={items}
                renderItem={({ item }) => (
                    <ListItem
                        label="Ônibus"
                        value={item.numero}
                        selected={item.selected}
                        onpress={() => chooseBus(item)}

                    />
                )}
            />

            <View style={styles.button}>
                {
                    (wait)
                        ? <Loading />
                        : <Button title="Selecionar" color={Cores.default} onPress={next} />
                }
            </View>
        </View>
    );
}

const styles = StyleSheet.create({
    page: {
        flex: 1,
    },
    container: {
        flex: 1,
        display: 'flex',
        flexDirection: 'column',
        borderBottomColor: Cores.default,
        borderBottomWidth: 1
    },
    button: {
        marginBottom: 30,
        marginTop: 20,
        width: '80%',
        alignSelf: 'center'
    },
    title: {
        fontSize: 30,
        fontWeight: 'bold',
        color: Cores.default_Dark,
        textAlign: 'center',
        padding: 5,
        borderBottomWidth: 1,
        borderBottomColor: Cores.default,

    }
});

export default SelectBus;