package com.example.alonzomobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Activity2_Display extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity2__display);

        Button conti = (Button) findViewById(R.id.btnConti);

        TextView name= (TextView) findViewById(R.id.txtName);
        TextView address = (TextView) findViewById(R.id.txtAddress);
        TextView email = (TextView) findViewById(R.id.txtEAddress);
        TextView phone = (TextView) findViewById(R.id.txtPhone);
        TextView gender = (TextView) findViewById(R.id.txtGender);
        TextView age = (TextView) findViewById(R.id.txtAge);

        Intent intent = getIntent() ;
        Intent jkl = new Intent(this, MainActivity2_Menu.class);

        String fname = intent.getStringExtra("name_key");
        String ages = intent.getStringExtra("age_key");
        String mail = intent.getStringExtra("eaddress_key");
        String add = intent.getStringExtra("address_key");
        String phones = intent.getStringExtra("phone_key");
        String genders = intent.getStringExtra("gender_key");

        name.setText("Name: "+fname);
        age.setText("Age: " +ages);
        gender.setText("Gender: " + genders);
        phone.setText("Phone Number: " + phones);
        address.setText("Address: " + add);
        email.setText("Email: " + mail);


        conti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(v.getId()){
                    case R.id.btnConti:
                     startActivity(jkl);
                }

            }
        });
    }


}