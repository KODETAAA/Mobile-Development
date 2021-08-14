package com.example.alonzomobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class Activity2_Register extends AppCompatActivity  {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity2__register);

        EditText txtName = (EditText) findViewById(R.id.txtName);
        EditText txtAge = (EditText) findViewById(R.id.txtAge);
        EditText Eaddress = (EditText) findViewById(R.id.txtEAddress);
        EditText  address = (EditText) findViewById(R.id.txtAddress);
        EditText  phone = (EditText) findViewById(R.id.txtPhone);

        RadioButton rbtnMale = (RadioButton) findViewById(R.id.rbtnMale);
        RadioButton rbtnFemale = (RadioButton) findViewById(R.id.rbtnFemale);
        //RadioButton  rbtnOther = (RadioButton) findViewById(R.id.rbtnOther);

        Button btnOk = (Button) findViewById(R.id.btnOk);
        Button btnClear = (Button) findViewById(R.id.btnClear);


        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = txtName.getText().toString();
                String add = address.getText().toString();
                String Eadd = Eaddress.getText().toString();
                String bir = phone.getText().toString();
                String age = txtAge.getText().toString();
                String gender = "Male";


               if(rbtnMale.isSelected())
                 gender = "Male";
               else
                   gender = "Female";


               /*
               switch (v.getId()){
                   case R.id.rbtnMale:
                       gender = "Male";
                       break;
                   case R.id.rbtnFemale:
                       gender = "Female";
                       break;
                   case R.id.rbtnOther:
                       gender = "Other";
                       break;
               }

                */


                Intent intent = new Intent(getApplicationContext(), Activity2_Display.class);



                intent.putExtra("name_key", name);
                intent.putExtra("address_key", add);
                intent.putExtra("eaddress_key", Eadd);
                intent.putExtra("phone_key", bir);
                intent.putExtra("gender_key", gender);
                intent.putExtra("age_key", age);
                startActivity(intent);

            }
        });


         btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                txtName.setText("");
                txtAge.setText("");
                Eaddress.setText("");
                address.setText("");
                phone.setText("");
                rbtnMale.setChecked(false);
                rbtnFemale.setChecked(false);
                //rbtnOther.setText(" ");

        }
    });

    }
}