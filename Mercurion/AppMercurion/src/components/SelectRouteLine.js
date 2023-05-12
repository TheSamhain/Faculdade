import React from 'react';
import { View, Text, Image, StyleSheet } from 'react-native';
import { Cores } from '../config/style';
import { Ionicons } from '@expo/vector-icons';

export default SelectRouteLine = ({ rota: { embarque, desembarque, linha } }) => {
    return (
        <View style={styles.selectRouteLine}>
            <Text style={[styles.lineName, styles.textBold]} >Linha {linha}</Text>
            <View style={styles.route} >
                <View style={styles.column}>
                    <Text style={[styles.textDefault, styles.textBold]}>Embarque</Text>
                    <Text style={[styles.textDefault, styles.textData]}>{embarque.titulo}</Text>
                    <Text style={[styles.textDefault, styles.textData]}>A {embarque.origDistancia} metros de você</Text>
                </View>

                <Ionicons name="arrow-forward" size={24} color={Cores.default} style={styles.seta} />


                <View style={styles.column}>
                    <Text style={[styles.textDefault, styles.textBold]}>Desmbarque</Text>
                    <Text style={[styles.textDefault, styles.textData]}>{desembarque.titulo}</Text>
                    <Text style={[styles.textDefault, styles.textData]}>A {desembarque.destDistancia} metros do destino</Text>
                </View>
            </View>
        </View>
    );
}

const styles = StyleSheet.create({
    selectRouteLine: {
        display: 'flex',
        flexDirection: 'column',
        alignItems: "center",
        padding: 10,
        backgroundColor: Cores.background_Light,
        borderBottomColor: Cores.default,
        borderBottomWidth: 1
    },
    route: {
        display: "flex",
        flexDirection: "row",
        alignItems: "center"
    },
    textBold: {
        fontWeight: "bold",
    },
    textDefault: {
        margin: 3
    },
    lineName: {
        fontSize: 18,
        color: Cores.default,
    },
    textData: {
        marginVertical: 5
    },
    column: {
        display: "flex",
        flexDirection: "column",
        height: "100%",
        flex: 1,
        backgroundColor: Cores.background_hidden
    },
    seta: {
        marginHorizontal: 5
    }
});
