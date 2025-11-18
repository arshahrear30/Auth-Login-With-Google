# Login-logout

GMAIL + Firebase dia korbo


## 3103

<uses-permission android:name="android.permission.INTERNET" />
    <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
    <uses-permission android:name="android.permission.ACCESS_WIFI_STATE" />



    Firebase > Go Consol > Name dilam > Project Overview Setting > Project Setting > Click on Android icon >Android package name(build gradle : Module er vitor  ) > com.arshahrear.authloginwithgoogle >App nickname>



 builde gradle Root-level mean app name jukto tay add korbo code ta plugins e 
    (app-level) Gradle file  e alias(libs.plugins.android.application)  eita thak but eita remove korbo id 'com.android.application'  beacuse both are same line .. 2nd line firebase theke paibo ar 1st line to android studio tey built in

Library add korbo


Built > Authentication > Get Started > Sign-in-method > Google > Enable > Support email for project > JSON file ta update hoi gecay >Done >Project overview >Project setting > nicay gele >Download the json file 


    File ta phaste korbo ..
Android to shift :: Project >1st file e > app folder e click korbo right button e click korbo . phaste korbo >

## 3104

Firebase > Project overview > Project Setting > নিচে গেলে > Add Fingerprint > এইখানে 3টা fingerprint add করতে হবে > 1টা হলো Debugging-এর জন্য (Testing device এর জন্য) > 2nd টা হলো যখন আমরা generate থেকে build করার পর apk / app bundel করবো > 3 নম্বরটা... Play Store-এ upload করার পর Play Store একটা fingerprint দিয়ে দেয় ঐটা।

Play Console এ > Test and release > App signing এইখানে last 2টা SHA1 (Upload key certificate, app signing key certificate) fingerprint code পেয়ে যাবো ।

Test fingerprint: Android Studio > File > Settings থেকে Experimental এর মধ্যে মার্ক করা অপশনটা টিক মার্ক করে তারপর (Already থাকলে ভালো) > Gradle > app > Tasks > android > signingReport (Double click) > SHA1: এটাই সেই fingerprint > এই fingerprint copy করে Firebase এ paste করবো ।

Google এ Search: firebase authentication android : Get Started with Firebase Authentication on Android : https://firebase.google.com/docs/auth/android/start

Add Firebase Authentication to your app :: implementation("com.google.firebase:firebase-auth") এই library add করবো । আর আগের library add করে ফেলেছি আগেই 

Search in chrome : Credential manager android :: About Credential Manager | Identity  :: https://developer.android.com/identity/sign-in/credential-manager-siwg#declare-dependencies :: 



-if class androidx.credentials.CredentialManager
-keep class androidx.credentials.playservices.** {
*;
}


proguard-rules.pro এর মধ্যে নিচে এই line গুলো add করবা:

-if class androidx.credentials.CredentialManager
-keep class androidx.credentials.playservices.** {
*;
}
Implement authentication with Sign in with Google:::Authenticate users with Sign in with Google::https://developer.android.com/identity/sign-in/credential-manager-siwg#instantiate-sign-in-request

Declare dependencies - 3টা library add করবো :: googleid click করে <latest version> এ add করবো । 1.1.1 এখন update দেখলাম


Firebase Authentication: এটা user-কে track রাখে যে user login করেছে কি না । user-এর name কী, email কী এইগুলো... এইগুলো store করে রাখবে। বারবার login করতে হবে না, auto একে একা বুঝে যাবে।

Google Credential manager: শুধু Google-এর option দেওয়ার জন্য এটা use করি।

## 3105

11:30 sec :::: Android studio package e click kori .. >>New >>Activity>>Empty view activity >>Login.java



## 3106

Search: lotte animation android   library add korba.. implementation "com.airbnb.android:lottie:3.4.0"


 res>Android Resorce directory >resorce type(raw) >  online theke lotte file download korci ... raw er modde phaste korci ... 
