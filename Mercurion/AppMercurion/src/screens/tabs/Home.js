import React from 'react';
import { NavigationContainer } from '@react-navigation/native';
import { createStackNavigator } from '@react-navigation/stack';
import MapTab from './HomeTabs/MapTab';
import SelectRoute from './HomeTabs/SelectRoute';
import { Cores } from '../../config/style';

const Stack = createStackNavigator();

export default function Home({ route }) {
  return (
    <Stack.Navigator initialRouteName="MapTab" screenOptions={headerHome} >
      <Stack.Screen initialParams={route.params} name="MapTab" component={MapTab} options={{ headerLeft: null, header: () => null }} />
      <Stack.Screen name="SelectRoute" component={SelectRoute} options={{ headerTitle: "Selecione uma rota" }} />
    </Stack.Navigator>
  );
}


const headerHome = {
  headerStyle: {
    backgroundColor: Cores.font_Light,
  },

  headerTintColor: Cores.default,
  headerTitleAlign: "center",
};