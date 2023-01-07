package com.example.a20184355mdp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MaterialButton createAccountBtn = (MaterialButton) findViewById(R.id.createAccountBtn);

        // directs to Create Account Page on clicked
        createAccountBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, CreateAccountPage.class));
            }
        });

        MaterialButton logInBtn = (MaterialButton) findViewById(R.id.logInBtn);

        // directs to Log In Page on clicked
        logInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, LoginPage.class));
            }
        });
    }
}