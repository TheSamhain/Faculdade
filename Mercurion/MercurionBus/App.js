import { Cores } from './src/config/style';
import React from 'react';
import { StyleSheet, View } from 'react-native';
import { NavigationContainer } from '@react-navigation/native';
import { createStackNavigator } from '@react-navigation/stack';
import { StatusBar } from 'expo-status-bar';
import Key from './src/screens/Key';
import SelectBus from './src/screens/SelectBus';
import SelectLine from './src/screens/SelectLine';
import ChangeBusAndLine from './src/screens/ChangeBusAndLine';

const Stack = createStackNavigator();

export default function App() {
  return (
    <View style={styles.main}>
      <StatusBar style="light" key="statusBar" backgroundColor={Cores.default} />
      <NavigationContainer>
        <Stack.Navigator initialRouteName="Key" screenOptions={defaultHeader} >
          <Stack.Screen name="Key" component={Key} options={{ headerLeft: null }} />
          <Stack.Screen name="SelectBus" component={SelectBus} options={{ headerLeft: null }} />
          <Stack.Screen name="SelectLine" component={SelectLine} options={{ headerLeft: null }} />
          <Stack.Screen name="ChangeBL" component={ChangeBusAndLine} options={{ headerLeft: null }} />
        </Stack.Navigator>
      </NavigationContainer>
    </View>
  );
}

const styles = StyleSheet.create({
  main: {
    flex: 1
  }
});

const defaultHeader = {
  title: 'MERCURION BUS',
  headerStyle: {
    backgroundColor: Cores.default,
  },
  headerTitleStyle: {
    fontWeight: 'bold',
    fontSize: 35
  },
  headerTintColor: Cores.font_Light,
  headerTitleAlign: "center",
};