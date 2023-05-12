import Login from './src/screens/Login';
import Main from './src/screens/Main';
import { Cores } from './src/config/style';
import React from 'react';
import { StyleSheet, View } from 'react-native';
import { NavigationContainer } from '@react-navigation/native';
import { createStackNavigator } from '@react-navigation/stack';
import { StatusBar } from 'expo-status-bar';

const Stack = createStackNavigator();

export default function App() {
  return (
    <View style={styles.main}>
      <StatusBar style="light" key="statusBar" backgroundColor={Cores.default} />
      <NavigationContainer>
        <Stack.Navigator initialRouteName="Login" screenOptions={defaultHeader} >
          <Stack.Screen name="Login" component={Login} options={{ headerLeft: null }} />
          <Stack.Screen name="Main" component={Main} options={{ headerLeft: null }} />
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
  title: 'MERCURION',
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