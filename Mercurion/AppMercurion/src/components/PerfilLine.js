import React from 'react';
import { View, Text, Image, StyleSheet } from 'react-native';
import { Cores } from '../config/style';

export default PerfilLine = ({ label = "", content  = "-"}) => {
    return (
        <View style={styles.perfilLine}>
            <Text style={[styles.cell, styles.label]}>{label}</Text>
            <Text style={[styles.cell, styles.content]}>{content}</Text>
        </View>
    );
}

const styles = StyleSheet.create({
    perfilLine: {
        display: 'flex',
        flexDirection: 'column',
        paddingTop: 3,
        paddingBottom: 3,
        marginBottom: 5        
    },
    cell: {
        fontSize: 18,
        paddingLeft: 5,
        
    },
    label: {
        fontWeight: 'bold',
        
    },

    longLabel: {
        fontSize: 12
    }
});
