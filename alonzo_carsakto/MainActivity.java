package com.example.alonzo_carsakto;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity{
    EditText email,pass;
    Button login, clr;
    TextView create;
    DBHelper_User op;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = (EditText) findViewById(R.id.txtUser);
        pass = (EditText) findViewById(R.id.txtPass);

        login = (Button) findViewById(R.id.btnLogin);
        clr = (Button) findViewById(R.id.btnClear);

        create = (TextView) findViewById(R.id.txtCreate);

        op = new DBHelper_User(this);

        clr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email.setText("");
                pass.setText("");
            }
        });

       login.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               String emails = email.getText().toString();
               String password = pass.getText().toString();

               if (emails.equals("") || password.equals("")) {
                   Toast.makeText(MainActivity.this, "Please enter all fields required!", Toast.LENGTH_SHORT).show();
               } else {
                   Boolean checkuserpass = op.checkEmailsandPassword(emails, password);

                   if (checkuserpass == true) {
                       Toast.makeText(MainActivity.this, "Logged in successfully!", Toast.LENGTH_SHORT).show();
                       Intent intent = new Intent(MainActivity.this, Menu.class);
                       startActivity(intent);
                   } else {
                       Toast.makeText(MainActivity.this, "Incorrect Username/Password!", Toast.LENGTH_SHORT).show();
                   }
               }
           }
       });

       create.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               String text = "New here? Click here to sign up";
               SpannableString op = new SpannableString(text);

               ClickableSpan kl = new ClickableSpan() {
                   @Override
                   public void onClick(@NonNull View widget) {
                        Intent jh = new Intent(MainActivity.this, createAcct.class);
                       startActivity(jh);
                       Toast.makeText(MainActivity.this, "Proceed to Creating Account", Toast.LENGTH_SHORT).show();
                   }
               };
               op.setSpan(kl, 10,20, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

               create.setText(op);
               create.setMovementMethod(LinkMovementMethod.getInstance());
           }
       });

       }
}