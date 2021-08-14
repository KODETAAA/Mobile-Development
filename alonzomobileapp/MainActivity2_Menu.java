package com.example.alonzomobileapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity2_Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2__menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity2_menu,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.menuItem1:
                Toast.makeText(this, "Register Menu is clicked", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, Activity2_Register.class);
                startActivity(intent);
                return true;

            case R.id.menuItem2:
                Toast.makeText(this, "About us is clicked", Toast.LENGTH_SHORT).show();
                Intent pok = new Intent(this, Activity2_About.class);
                startActivity(pok);
                return true;

            case R.id.menuItem3:
                Toast.makeText(this, "Contact us is clicked", Toast.LENGTH_SHORT).show();
                Intent you = new Intent(this, Activity2_Contact.class);
                startActivity(you);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}