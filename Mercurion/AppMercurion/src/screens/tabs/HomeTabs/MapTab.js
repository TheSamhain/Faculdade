import { Cores } from '../../../config/style';
import React, { useEffect, useState } from 'react';
import { View, StyleSheet, TextInput, Image, Alert, Text, Button, BackHandler, Keyboard } from 'react-native';
import { TouchableOpacity } from 'react-native-gesture-handler';
import Loading from '../../../components/Loading';
import Map from '../../../components/Map';
import { Ionicons } from '@expo/vector-icons';
import * as Location from 'expo-location';
import { Dimensions } from 'react-native';

import Geocoder from 'react-native-geocoding';

export default function MapTab({ navigation, route }) {
    const { idUser } = route.params;

    const
        [where, setWhere] = useState(""),
        [coordinates, setCordinates] = useState(null),
        [destination, setDestination] = useState(null);

    var inputSearch;

    useEffect(() => {
        if (coordinates != null)
            return;

        const config = async () => {
            let { status } = await Location.requestPermissionsAsync();

            if (status !== 'granted') {
                Alert.alert("Erro", "Permissão de acesso a localização negada!", [{
                    text: "Tentar novamente",
                    onPress: () => config()
                }]);
                return;
            }

            if (coordinates == null) {
                let location = await Location.getCurrentPositionAsync();

                const
                    { width, height } = Dimensions.get('window'),
                    latitudeDelta = 0.02,
                    longitudeDelta = latitudeDelta * (width / height);

                setCordinates({
                    latitude: location.coords.latitude,
                    longitude: location.coords.longitude,
                    latitudeDelta: latitudeDelta,
                    longitudeDelta: longitudeDelta
                });
            }
        };

        const timeOut = () => {
            if (coordinates == null) {
                config();

                setTimeout(() => {
                    timeOut();
                }, 5000);
            }
        }

        timeOut();

    }, []);

    const searchLocal = () => {
        if (where.trim() == "") {
            wrongLocal();
            Alert.alert("Digite o destino!");
            return;
        }

        inputSearch.blur();

        Geocoder.init("AIzaSyDL9QkMkYhJXjVAUyfTWpy5XMYF5aZdL_k");

        Geocoder.from(where + ' - São Cristóvão do Sul')
            .then(json => {
                const location = json.results[0].geometry.location;

                setDestination({
                    latitude: location.lat,
                    longitude: location.lng
                });
            })
            .catch(error => console.warn(error));
    }

    const wrongLocal = () => {
        setDestination(null);
        setWhere("");
        inputSearch.focus();
    }

    const correctLocal = () => {
        if (destination == null) {
            Alert.alert("Selecione o destino!");
            return;
        }

        setWhere("");
        inputSearch.blur();

        Location.getCurrentPositionAsync()
            .then(origin => {
                origin = {
                    latitude: origin.coords.latitude,
                    longitude: origin.coords.longitude
                }

                navigation.push("SelectRoute", {
                    origin,
                    destination
                });
            });
    }

    return (
        <View style={styles.main}>
            <View style={styles.searchView}>
                <View style={styles.search} >
                    <TextInput
                        style={styles.input}
                        editable
                        placeholder="Para onde deseja ir?"
                        maxLength={40}
                        value={where}
                        onChangeText={(text) => setWhere(text)}
                        ref={(input) => { inputSearch = input; }}
                    />

                    <TouchableOpacity onPress={() => setWhere("")}>
                        <Ionicons name="close-outline" size={24} color={Cores.default} style={styles.deleteIcon} />
                    </TouchableOpacity>

                    <TouchableOpacity onPress={searchLocal}>
                        <Ionicons name="search" size={24} color={Cores.default} style={styles.searchIcon} />
                    </TouchableOpacity>
                </View>

            </View>

            {(coordinates == null)
                ? <Loading />
                : <Map
                    idUser={idUser}
                    coordinates={coordinates}
                    destination={destination}
                    setDestination={setDestination} />
            }

            {(destination != null) &&
                <View style={styles.confirmationView}>
                    <Text style={styles.confirmationText} >Este é o local correto?</Text>
                    <View style={styles.buttonsView}>
                        <TouchableOpacity
                            style={[styles.confirmBtn, { backgroundColor: Cores.sucess }]}
                            onPress={correctLocal} >
                            <Text style={styles.confirmBtnText} >Sim</Text>
                        </TouchableOpacity>

                        <TouchableOpacity
                            style={[styles.confirmBtn, { backgroundColor: Cores.erro }]}
                            onPress={wrongLocal} >
                            <Text style={styles.confirmBtnText} >Não</Text>
                        </TouchableOpacity>

                    </View>
                </View>
            }
        </View>

    );
};

const styles = StyleSheet.create({
    main: {
        flex: 1,
        // marginTop: StatusBar.currentHeight
    },
    searchView: {
        zIndex: 2,
        position: 'absolute',
        height: 90,
        display: 'flex',
        flexDirection: "row",
        justifyContent: "center",
        alignItems: "center",
        maxHeight: 500,
        width: '100%',
    },
    search: {
        backgroundColor: Cores.background_Light,
        borderWidth: 1,
        borderColor: Cores.default,
        height: 40,
        width: "90%",
        padding: 5,
        marginBottom: 10,
        flexDirection: "row",
        justifyContent: "space-between",
        alignItems: "center",
    },
    input: {
        fontSize: 20,
        flex: 1,
    },
    deleteIcon: {
        marginRight: 5,
        marginTop: 2
    },
    searchIcon: {
        marginRight: 5,
        marginTop: 2,
        marginLeft: 5
    },

    confirmationView: {
        zIndex: 2,
        position: 'absolute',
        height: 90,
        display: 'flex',
        flexDirection: "column",
        justifyContent: "center",
        alignItems: "center",
        width: '90%',
        backgroundColor: Cores.background_Light,
        borderRadius: 10,
        bottom: 15,
        marginLeft: "5%",
        borderColor: Cores.default,
        borderWidth: 1
    },
    buttonsView: {
        display: "flex",
        flexDirection: "row",
        justifyContent: "center",
        minWidth: "50%",

    },
    confirmationText: {
        fontSize: 18,
        color: Cores.font_Dark,
        marginBottom: 5
    },

    confirmBtn: {
        margin: 5,
        borderRadius: 5,
        padding: 5,
        paddingHorizontal: 10,
        marginHorizontal: 10,
    },

    confirmBtnText: {
        fontSize: 18,
        color: Cores.font_Light,
    }
});
