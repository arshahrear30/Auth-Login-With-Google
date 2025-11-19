package com.arshahrear.authloginwithgoogle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.credentials.Credential;
import androidx.credentials.CredentialManager;
import androidx.credentials.CredentialManagerCallback;
import androidx.credentials.GetCredentialRequest;
import androidx.credentials.GetCredentialResponse;
import androidx.credentials.exceptions.GetCredentialException;

import com.google.android.gms.common.SignInButton;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.libraries.identity.googleid.GetSignInWithGoogleOption;
import com.google.android.libraries.identity.googleid.GoogleIdTokenCredential;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.GoogleAuthCredential;
import com.google.firebase.auth.GoogleAuthProvider;

public class Login extends AppCompatActivity {
    SignInButton googleLogin;
    CredentialManager credentialManager;
    GetCredentialRequest credentialRequest;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        googleLogin = findViewById(R.id.googleLogin);
        credentialManager=CredentialManager.create(Login.this);
        mAuth = FirebaseAuth.getInstance();

        //google Option create korbo ...
        GetSignInWithGoogleOption googleOption=new GetSignInWithGoogleOption.Builder(getString(R.string.googleLogin_ClientId))
                .setNonce(java.util.UUID.randomUUID().toString() ) //client id key secuirity dewar jonno nonce use korci .. etay ektagenerated random string use kortay hou but ekon taratarir jonno java util er tai niye nilam .
                .build();

        //credential request kortay hoibay .. tai credential request name object toiri korbo
        credentialRequest = new GetCredentialRequest.Builder()
                .addCredentialOption(googleOption)
                .build();

        googleLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                requestGoolelogin();
            }
        });

    }

    //==============================
    public void requestGoolelogin(){
        credentialManager.getCredentialAsync(Login.this, credentialRequest, null, Runnable::run, new CredentialManagerCallback<GetCredentialResponse, GetCredentialException>() {
            @Override
            public void onResult(GetCredentialResponse credentialRequest) {//kon gmail select korbay ei kane asbay

                Credential credential=credentialRequest.getCredential();
                GoogleIdTokenCredential googleIdTokenCredential= GoogleIdTokenCredential.createFrom(credential.getData());
                String idToken = googleIdTokenCredential.getIdToken(); //id token er jonno ei 3 line likci

                Toast.makeText(getApplicationContext(),""+idToken,Toast.LENGTH_SHORT).show();

                AuthCredential authCredential = GoogleAuthProvider.getCredential(idToken,null);

                mAuth.signInWithCredential(authCredential) //firebase er loge connect korci and login hoicay
                        .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                            @Override
                            public void onSuccess(AuthResult authResult) {
                                startActivity(new Intent(Login.this, MainActivity.class));
                                finish();
                            }
                        });
            }

            @Override
            public void onError(@NonNull GetCredentialException e) {
                //error handle
                Toast.makeText(getApplicationContext(),"Login Failed: "+e.getMessage(),Toast.LENGTH_LONG).show();
            }
        });
    }
    //==============================
}
