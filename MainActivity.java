package com.arshahrear.authloginwithgoogle;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {


    TextView tvName, tvEmail;
    ImageView imgProfile;
    Button buttonLogout;

    FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        tvName = findViewById(R.id.tvName);
        tvEmail = findViewById(R.id.tvEmail);
        imgProfile = findViewById(R.id.imgProfile);
        buttonLogout = findViewById(R.id.buttonLogout);

        firebaseAuth = FirebaseAuth.getInstance();//firebaseAuth ke initialize kore fellam getInstance etar maddome



    }

    //------------- Mouse Right Button >> Generate >> Overright method(search:onStart) >> onStart method activity launch hower sate sate eka eka kaz kore

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser(); //Auth theke user ke kujtecay . user log in kora thakle null hobe ...

        if(firebaseUser!=null){
            //There is a user logged in
        }else{

            //There is no user logged in --> Send him to login page

            Intent intent = new Intent(MainActivity.this, Login.class);
            startActivity(intent);
            finish();


        }

    }


    //-------------




}
