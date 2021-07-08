import firebase from "firebase/app"
import "firebase/auth"
import "firebase/storage"
import "firebase/firestore"

firebase.initializeApp(
    
        {
            apiKey: "AIzaSyDB8WFie5LyOm2Ry5ztiT8SGiqs-0ewwnk",
            authDomain: "reels-class-1a63e.firebaseapp.com",
            projectId: "reels-class-1a63e",
            storageBucket: "reels-class-1a63e.appspot.com",
            messagingSenderId: "494936314828",
            appId: "1:494936314828:web:b352a0254e84eb6c33c369"
          }
    
)

export const auth = firebase.auth();

const firestore = firebase.firestore();
export const database={
    users: firestore.collection('users'), // for abstraction, and not exposing the entire firestore
    getCurrentTimeStamp : firebase.firestore.FieldValue.serverTimestamp
}

export const storage = firebase.storage();
// export default firebase;