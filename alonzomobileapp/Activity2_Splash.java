package com.example.alonzomobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class Activity2_Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity2__splash);


        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                Intent i = new Intent(Activity2_Splash.this, MainActivity2_Menu.class);
                startActivity(i);
                finish();
            }
        }, 3000);

    }
}