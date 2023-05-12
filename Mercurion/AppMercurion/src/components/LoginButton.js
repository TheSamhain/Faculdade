import React from 'react';
import { TouchableOpacity } from 'react-native-gesture-handler';
import { Text, StyleSheet, Image } from 'react-native';
import { Cores } from '../config/style';
import { Ionicons } from '@expo/vector-icons';

const LoginButton = ({ title, icon, onPress }) => {
    return (
        <TouchableOpacity
            style={styles.button}
            onPress={onPress}
        >
            <Ionicons name={icon} size={35} color={Cores.font_Light} />
            <Text style={styles.text}>{title}</Text>
        </TouchableOpacity>
    );
}

const styles = StyleSheet.create({
    button: {
        backgroundColor: Cores.default,
        padding: 5,
        borderRadius: 5,
        flexDirection: "row",
        alignItems: "center",
        justifyContent: "space-between",
        margin: 20,
        width: 250,

        shadowColor: Cores.shadow,
        shadowOffset: {
            width: 0,
            height: 3,
        },
        shadowOpacity: 0.27,
        shadowRadius: 4.65,

        elevation: 5,
    },
    text: {
        color: Cores.font_Light,
        fontSize: 15,
        fontWeight: "bold",
        margin: 5,
        flex: 1,
        textAlign: 'center'
    }
});

export default LoginButton;