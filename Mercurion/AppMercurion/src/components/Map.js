import React, { useEffect, useState } from 'react';
import { StyleSheet } from 'react-native';
import MapView, { Marker } from 'react-native-maps';
import { Ionicons } from '@expo/vector-icons';
import { Cores } from '../config/style';
import IconBus20 from './svg/IconBus20';
import { firebaseDB } from '../config/db.firebase';
import MapViewDirections from 'react-native-maps-directions';
import base64 from '../components/base64';
import BusStop32 from './svg/BusStop32';

export default function Map({ coordinates, destination, idUser }) {
    const
        [listBus, setListBus] = useState([]),
        [listLines, setListLines] = useState([]),
        [listStops, setListStops] = useState([]),
        [mapClean, setMapClean] = useState(false);

    useEffect(() => {
        firebaseDB.ref(`usuarios/${idUser}/mapaLimpo`).on('value', mapaLimpo => {
            setMapClean(mapaLimpo.val());
        })

        firebaseDB.ref("onibus").on('value', onibusList => {
            setListBus([]);

            onibusList.forEach(onibus => {
                let key = onibus.key;
                onibus = onibus.val();

                if (!!onibus.conduzindo) {
                    onibus.id = key;
                    setListBus(oldArray => [...oldArray, onibus]);
                }
            })
        })

        firebaseDB.ref("linhas").once('value', linhasList => {
            setListLines([]);

            linhasList.forEach(linha => {
                let key = linha.key;
                linha = linha.val();

                if (!Array.isArray(linha.coordenadas) || !linha.coordenadas || (typeof (linha.coordenadas) == 'undefined'))
                    return;

                if (linha.coordenadas.length > 2) {
                    linha.id = key;
                    setListLines(oldArray => [...oldArray, linha]);
                }
            })
        })

        firebaseDB.ref("pontos").once('value', pontosList => {
            setListStops([]);

            pontosList.forEach(ponto => {
                let key = ponto.key;
                ponto = ponto.val();

                if (!!ponto.coordenadas) {
                    ponto.id = key;
                    setListStops(oldArray => [...oldArray, ponto]);
                }
            })
        })

    }, []);

    const buses = listBus.map(bus => {
        const latLong = bus.atualLatLong.split(', ');

        if (latLong.length != 2) {
            return null;
        }

        const lat = latLong[0],
            long = latLong[1];

        return (
            <Marker
                key={bus.id}
                coordinate={{ latitude: Number(lat), longitude: Number(long) }}
                title={`Ônibus: ${bus.numero}`}

            >
                <IconBus20 />
                {/* <Ionicons name="bus" size={24} color={Cores.default} backgroundColor="#fff" /> */}
            </Marker>
        )
    })

    const line = listLines.map(linha => {
        const latLong = linha.coordenadas.map(coord => {
            const arrLatLong = coord.split(', ');

            if (arrLatLong.length != 2) {
                return null;
            }

            return { latitude: Number(arrLatLong[0]), longitude: Number(arrLatLong[1]) }
        })

        if (latLong.length < 3) {
            return null;
        }

        const
            initLatLong = latLong[0],
            lastLatLong = latLong[latLong.length - 1];

        latLong.shift();

        return (
            <MapViewDirections
                key={linha.id}
                origin={initLatLong}
                destination={initLatLong}
                strokeWidth={3}
                strokeColor={Cores.default}
                waypoints={latLong}
                apikey={base64.atob("QUl6YVN5QU53NngxSUY4QXo1LTh6VWdqVWNoSTlYMU1OZWpKdXo0")}
            />
        )
    });

    const stops = listStops.map(stop => {
        const latLong = stop.coordenadas.split(', ');

        if (latLong.length != 2) {
            return null;
        }

        const lat = latLong[0],
            long = latLong[1];

        return (
            <Marker
                key={stop.id}
                coordinate={{ latitude: Number(lat), longitude: Number(long) }}
                title={stop.titulo}
                description={stop.descricao}

            >
                <BusStop32 />
            </Marker>
        )
    })

    destination =
        destination &&
        {
            ...destination,
            latitudeDelta: 0.002,
            longitudeDelta: 0.002,
        };

    return (
        <MapView
            style={styles.map}
            loadingEnabled={true}
            maxZoomLevel={20}
            rotateEnabled={false}
            showsUserLocation={true}
            initialRegion={coordinates}
            provider='google'
            region={(destination != null) ? destination : null}
            mapType={mapClean ? "mutedStandard" : "standard"}
            showsBuildings={!mapClean}
        >
            {buses}
            {line}
            {stops}
            {(destination != null) &&
                <Marker
                    key="Destination"
                    coordinate={destination/*{ latitude: Number(destination.latitude), longitude: Number(destination.longitude) }*/}
                    title={`Local escolhido`}
                />
            }
        </MapView>
    );
}


const styles = StyleSheet.create({
    map: {
        flex: 1,
        marginTop: 2,
        height: '100%'
    }
});

