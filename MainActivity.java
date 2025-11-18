package com.arshahrear.authloginwithgoogle;

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
}
