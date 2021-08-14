package com.example.alonzomobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnHelloWorld, btnExercise1, btnAct1, btnAct2, btnAct3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnHelloWorld = (Button) findViewById(R.id.btnHelloWorld);
        btnExercise1 = (Button) findViewById(R.id.btnExercise1);
        btnAct1 = (Button) findViewById(R.id.btnAct1);
        btnAct2 = (Button) findViewById(R.id.btnAct2);
        btnAct3 = (Button) findViewById(R.id.btnAct3);

        btnHelloWorld.setOnClickListener(this);
        btnExercise1.setOnClickListener(this);
        btnAct1.setOnClickListener(this);
        btnAct2.setOnClickListener(this);
        btnAct3.setOnClickListener(this);


        //        btnHelloWorld.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(MainActivity.this, "This button is clicked!", Toast.LENGTH_SHORT).show();
 //           }
 //       });

        }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnHelloWorld:
                Toast.makeText(MainActivity.this, "Hello World button is clicked!", Toast.LENGTH_SHORT).show();
                //Intent intent = new Intent(this, MainActivity.class);
                //startActivity(intent);
                break;
            case R.id.btnExercise1:
                Toast.makeText(MainActivity.this, "Exercise 1 button is clicked!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, MyActivity1Circle.class);
                startActivity(intent);
                break;
            case R.id.btnAct1:
                Toast.makeText(MainActivity.this, "Activity 1 button is clicked!", Toast.LENGTH_SHORT).show();
                Intent intent1 = new Intent(this, Activity1Package.class);
                startActivity(intent1);
                    break;
            case R.id.btnAct2:
                Toast.makeText(MainActivity.this, "Activity 2 button is clicked!", Toast.LENGTH_SHORT).show();
                Intent df = new Intent(this, Activity_Menu.class);
                startActivity(df);
                break;
            case R.id.btnAct3:
                Toast.makeText(MainActivity.this, "Activity 3 button is clicked!", Toast.LENGTH_SHORT).show();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + v.getId());
        }
}
}
