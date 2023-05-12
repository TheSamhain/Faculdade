import * as firebase from 'firebase';

// Your web app's Firebase configuration
// For Firebase JS SDK v7.20.0 and later, measurementId is optional
var firebaseConfig = {
  apiKey: "AIzaSyA5LVHS4PJkLg_7uyM4KXVl2gJVjF-0dcs",
  authDomain: "mercurion-2685d.firebaseapp.com",
  databaseURL: "https://mercurion-2685d.firebaseio.com",
  projectId: "mercurion-2685d",
  storageBucket: "mercurion-2685d.appspot.com",
  messagingSenderId: "705230057561",
  appId: "1:705230057561:web:e7fdd61ac5f03b9cd00148",
  measurementId: "G-JNWSDDK68F"
};

// Initialize Firebase
const firebaseImpl = firebase.initializeApp(firebaseConfig);
const firebaseDB = firebase.database();

export {
  firebaseImpl,
  firebaseDB
};