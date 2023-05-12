import { Cores } from '../config/style';

import React from 'react';
import { ActivityIndicator, StyleSheet, Text, TouchableOpacity, View } from "react-native";

const ListItem = ({label, value, selected, onpress}) => {
  return (
    <TouchableOpacity style={[styles.line, selected ? styles.selected : styles.normal]} onPress={onpress}>
      <Text style={[selected ? styles.textSelected : styles.textNormal]}>{label}:</Text>
      <Text style={[selected ? styles.textSelected : styles.textNormal, styles.value]}>{value}</Text>
    </TouchableOpacity>
  );
}

const styles = StyleSheet.create({
  line: {
    padding: 10,
    borderBottomWidth: 1,
    borderBottomColor: Cores.default,
    flexDirection: 'row'
  },
  normal: {
    backgroundColor: Cores.background_LowLight,
  },
  selected: {
    backgroundColor: Cores.default,
  },
  textNormal: {
    fontSize: 20,
    color: Cores.font_Dark,
    marginVertical: 5,
  },
  textSelected: {
    fontSize: 20,
    color: Cores.font_Light,
    marginVertical: 5,
  },
  value: {
    fontWeight:'bold',
    marginLeft: 5
  }
});

export default ListItem;