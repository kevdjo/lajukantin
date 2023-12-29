package com.example.lajukantin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SplashActivity2 extends AppCompatActivity {
    private TextView signupRedirectText, signinRedirectText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash2);
        signupRedirectText = findViewById(R.id.signUpRedirectText);
        signinRedirectText = findViewById(R.id.signInRedirectText);

        signupRedirectText.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent1 = new Intent(SplashActivity2.this, SignUpActivity.class);
                startActivity(intent1);
            }
        });
        signinRedirectText.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent1 = new Intent(SplashActivity2.this, SignInActivity.class);
                startActivity(intent1);
            }
        });
    }
}