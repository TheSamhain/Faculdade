import React, { useEffect } from 'react';
import { createBottomTabNavigator } from '@react-navigation/bottom-tabs';
import Home from '../screens/tabs/Home';
import Profile from '../screens/tabs/Profile';
import { BackHandler } from 'react-native';
import History from '../screens/tabs/History';
import { Ionicons } from '@expo/vector-icons';
import { Cores } from '../config/style';


const Tab = createBottomTabNavigator();

export default function Main({ route: { params }, navigation }) {

  // Impede de voltar para a tela anterior
  useEffect(() => {
    navigation.addListener('beforeRemove', (e) => {
      e.preventDefault();

      if (e.data.action.type != "NAVIGATE") {
        BackHandler.exitApp();
        return;
      }

      navigation.dispatch(e.data.action)
    })
  }, [navigation]);

  return (
    <Tab.Navigator >
      <Tab.Screen
        name="Home"
        component={Home}
        options={{
          title: () => null,
          tabBarIcon: ({ focused }) => <Ionicons name={`location${focused ? '' : '-outline'}`} size={30} color={Cores.default} />
        }}
        initialParams={{ idUser: params.idUser }}
      />

      {/* <Tab.Screen
        name="History"
        component={History}
        options={{
          title: () => null,
          tabBarIcon: ({ focused }) => <Ionicons name={`reader${focused ? '' : '-outline'}`} size={30} color={Cores.default} />
        }}
        initialParams={params}
      /> */}

      <Tab.Screen
        name="Profile"
        component={Profile}
        options={{
          title: () => null,
          tabBarIcon: ({ focused }) => <Ionicons name={`person${focused ? '' : '-outline'}`} size={30} color={Cores.default} />,
        }}
        initialParams={params}

      />

    </Tab.Navigator>
  );

};
