package com.example.alonzomobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MyExerciseCircle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_activity1_circle);

        Button btnCalculate;
        TextView txtArea, txtCircumference;
        EditText txtRadius;

        btnCalculate = (Button) findViewById(R.id.btnCalculate);
        txtRadius = (EditText) findViewById(R.id.txtRadius);
        txtArea = (TextView) findViewById(R.id.txtArea);
        txtCircumference = (TextView) findViewById(R.id.txtCircumference);

        //btnCalculate.setOnClickListener(this);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String fag = String.valueOf(txtRadius.getText());
                int rad = Integer.parseInt(fag);
                double radius =  (double) rad;

                double area = Math.PI * Math.pow(radius, 2);
                double circ = 2 * Math.PI * radius;

                txtArea.setText(String.valueOf(area));
                txtCircumference.setText(String.valueOf(circ));

            }
        });

    }
}