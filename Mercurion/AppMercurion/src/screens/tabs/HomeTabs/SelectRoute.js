import React, { useEffect, useState } from 'react';
import { ScrollView, StyleSheet, Text, View } from 'react-native';
import { firebaseDB } from '../../../config/db.firebase';
import { Cores } from '../../../config/style';
import { getDistance } from '../../../utils';
import SelectRouteLine from '../../../components/SelectRouteLine';

export default function SelectRoute({ route }) {
    const { destination, origin } = route.params;
    const [listLines, setListLines] = useState([]);

    useEffect(() => {
        firebaseDB.ref("linhas").once('value', linhasList => {
            setListLines([]);

            linhasList.forEach(linha => {
                let key = linha.key;
                linha = linha.val();

                if (!Array.isArray(linha.coordenadas) || !linha.coordenadas || (typeof (linha.coordenadas) == 'undefined'))
                    return;

                if (!Array.isArray(linha.pontos) || !linha.pontos || (typeof (linha.pontos) == 'undefined')) {
                    return
                }

                linha.pontosDestino = [];
                linha.pontosOrigem = [];

                linha.pontos = linha.pontos.map(ponto => {
                    if (!!ponto.coordenadas) {
                        // Verifica se as coordenadas do ponto são válidas
                        const latLong = ponto.coordenadas.split(', ');

                        if (latLong.length != 2) {
                            return;
                        }

                        // Separa a latitude e longitude do ponto de ônibus
                        ponto.latitude = latLong[0];
                        ponto.longitude = latLong[1];


                        delete ponto.coordenadas;

                        ponto.destDistancia = getDistance(destination, ponto);
                        ponto.origDistancia = getDistance(origin, ponto);

                        if (ponto.destDistancia <= 200) { // utilizar 1000 m para produção, 200m apenas para teste
                            linha.pontosDestino.push(ponto);
                            linha.pontosDestino = linha.pontosDestino.sort((ponto1, ponto2) => ponto1.destDistancia - ponto2.destDistancia);
                        }

                        if (ponto.origDistancia <= 200) { // utilizar 1000 m para produção, 200m apenas para teste
                            linha.pontosOrigem.push(ponto);
                            linha.pontosOrigem = linha.pontosOrigem.sort((ponto1, ponto2) => ponto1.origDistancia - ponto2.origDistancia);
                        }

                        return ponto;
                    }
                });

                if (linha.pontosDestino.length == 0) {
                    return;
                }

                if (linha.coordenadas.length > 2) {
                    linha.id = key;
                    setListLines(oldArray => [...oldArray, linha]);
                }

            })
        })
    }, []);

    let items = [];

    listLines.forEach(line => {
        line.pontosOrigem.forEach(pontoOrig => {
            line.pontosDestino.forEach(pontoDest => {
                items.push({ embarque: pontoOrig, desembarque: pontoDest, linha: line.nome })
            });
        })

    });

    return (
        <ScrollView style={styles.selectRoute}>
            {items.map((item, index) => <SelectRouteLine rota={item} key={index} />)}
        </ScrollView>
    );
}

const styles = StyleSheet.create({
    selectRoute: {
        flex: 1,
        display: "flex",
        flexDirection: "column",
    }
});