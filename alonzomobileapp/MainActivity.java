package com.example.alonzomobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements  View.OnClickListener{

    Button btn1, btn2, btn3, btn4, btn5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = (Button) findViewById(R.id.button1);
        btn2 = (Button) findViewById(R.id.button2);
        btn3 = (Button) findViewById(R.id.button3);
        btn4 = (Button) findViewById(R.id.button4);
        btn5 = (Button) findViewById(R.id.button5);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
       /* btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Hello World!", Toast.LENGTH_SHORT).show();
            }
        });*/

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button1:
                Toast.makeText(MainActivity.this, "Hello World!", Toast.LENGTH_SHORT).show();
                Intent sad = new Intent(this, HelloWorld.class);
                startActivity(sad);
                break;
            case R.id.button2:
                Toast.makeText(MainActivity.this, "Exercise 1 is clicked!", Toast.LENGTH_SHORT).show();
                Intent var = new Intent(this, MyExerciseCircle.class);
                startActivity(var);
                break;
            case R.id.button3:
                Toast.makeText(MainActivity.this, "Activity 1 is clicked!", Toast.LENGTH_SHORT).show();
                Intent opp = new Intent(this, MainActivity1.class);
                startActivity(opp);
                break;
            case R.id.button4:
                Toast.makeText(MainActivity.this, "Activity 2 is clicked!", Toast.LENGTH_SHORT).show();
                Intent gf = new Intent(this, Activity2_Splash.class);
                startActivity(gf);
                break;
            case R.id.button5:
                Toast.makeText(MainActivity.this, "Activity 3 is clicked!", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}

