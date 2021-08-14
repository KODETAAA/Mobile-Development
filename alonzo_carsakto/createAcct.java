package com.example.alonzo_carsakto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class createAcct extends AppCompatActivity {

   // TextView userID;
    EditText fname,password,emailad,contact;
    Button proceed;
    DBHelper_User kj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_acct);
        kj = new DBHelper_User(this);

        proceed = (Button) findViewById(R.id.btnProceed);

        fname = (EditText) findViewById(R.id.txtFullname);
        password = (EditText) findViewById(R.id.txtPassword);
        emailad = (EditText) findViewById(R.id.txtEmail);
        contact = (EditText) findViewById(R.id.txtContact);

        //userID = (TextView) findViewById(R.id.txtID);
        Intent intent = new Intent(this, MainActivity.class);

        proceed.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

            UserAcct user;

            try {
                user = new UserAcct(-1, fname.getText().toString(), password.getText().toString(), emailad.getText().toString(),contact.getText().toString());
                Toast.makeText(createAcct.this, user.toString(), Toast.LENGTH_SHORT).show();
                boolean lop = kj.createUser(user);
                Toast.makeText(createAcct.this, "Data Inserted" + lop, Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }catch (Exception e){
                Toast.makeText(createAcct.this, "Cannot be Inserted", Toast.LENGTH_SHORT).show();
                //user = new UserAcct(-1,"error","0","0","0");
            }

            }
        });

    }



}

