import { Cores } from '../config/style';

import React from 'react';
import { ActivityIndicator, StyleSheet, View } from "react-native";

const Loading = () => {
  return (
    <View style={styles.page}>
      <ActivityIndicator size="large" color={Cores.default} />
    </View>
  );
}

const styles = StyleSheet.create({
  page: {
    flex: 1,
    alignItems: "center",
    justifyContent: "center"
  }
});

export default Loading;