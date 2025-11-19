package com.arshahrear.authloginwithgoogle;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.credentials.CredentialManager;
import androidx.credentials.GetCredentialRequest;

import com.google.android.gms.common.SignInButton;
import com.google.android.libraries.identity.googleid.GetSignInWithGoogleOption;

public class Login extends AppCompatActivity {

    SignInButton googleLogin;
    CredentialManager credentialManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);


        googleLogin = findViewById(R.id.googleLogin);
        credentialManager=CredentialManager.create(Login.this);


        //google Option create korbo ...

        GetSignInWithGoogleOption googleOption=new GetSignInWithGoogleOption.Builder(getString(R.string.googleLogin_ClientId))
                .setNonce(java.util.UUID.randomUUID().toString() ) //client id key secuirity dewar jonno nonce use korci .. etay ektagenerated random string use kortay hou but ekon taratarir jonno java util er tai niye nilam . 
                .build();


        //credential request kortay hoibay .. tai credential request name object toiri korbo

        GetCredentialRequest request = new GetCredentialRequest.Builder()
                .addCredentialOption(googleOption)
                .build();





        googleLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //
            }
        });


    }
}
