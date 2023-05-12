import React from 'react';
import { Text, Image, StyleSheet } from 'react-native';

export default function History({ navigation, route }) {
    const
        { params } = route,
        { usuario } = params;

    return (
        <Text>Historico</Text>
    );
}
