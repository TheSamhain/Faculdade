import AsyncStorage from '@react-native-async-storage/async-storage';
import React, { useEffect, useState } from 'react';
import { View, StyleSheet, Text, FlatList, Button, Alert } from 'react-native';
import ListItem from '../components/ListItem';
import Loading from '../components/Loading';
import { firebaseDB } from '../config/db.firebase';
import { Cores } from '../config/style';

const SelectLine = ({ navigation, route: { params } }) => {
    const
        [items, setItems] = useState([]),
        [wait, setWait] = useState(true),
        { idBus } = params;

    // Exibe lista de linhas    
    useEffect(() => {
        setItems([]);

        firebaseDB.ref("linhas").once('value').then(linhas => {
            linhas.forEach(linha => {
                let key = linha.key
                linha = linha.val();
                linha.id = key;
                setItems(oldArray => [...oldArray, linha]);
            })

            setWait(false);
        });
    }, [])

    // Seleciona uma linha
    const chooseLine = (line) => {
        setItems(arr =>
            arr.map(item => {
                item.selected = (item.id == line.id);
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
            Alert.alert("Aviso", "Selecione uma linha da lista para prosseguir")
            return;
        }

        setWait(true);

        firebaseDB.ref("onibus/" + idBus).update({ linha: selected.id }, (err) => {
            setWait(false);

            if (err) {
                Alert.alert('Não foi possível selecionar o ônibus\nTente novamente.');
            } else {
                navigation.navigate("ChangeBL", { idBus, idLine: selected.id });
            }
        });


    }

    return (
        <View style={styles.page}>
            <Text style={styles.title}>Selecione uma linha</Text>

            <FlatList
                style={styles.container}
                data={items}
                renderItem={({ item }) => (
                    <ListItem
                        label="Linha"
                        value={item.nome}
                        selected={item.selected}
                        onpress={() => chooseLine(item)}
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
        color: Cores.font_Dark,
        textAlign: 'center',
        padding: 5,
        borderBottomWidth: 1,
        borderBottomColor: Cores.default
    }
});

export default SelectLine;

