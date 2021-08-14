package com.example.alonzo_carsakto;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

public class Menu extends AppCompatActivity {

    Button visit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        visit = (Button) findViewById(R.id.btnVisit);

        visit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switch (v.getId()){
                    case R.id.btnVisit:
                        Intent jk = new Intent("google.com");
                        startActivity(jk);

                }
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        MenuInflater ml = getMenuInflater();
        ml.inflate(R.menu.menulist,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.menuItem1:
                Intent gh = new Intent(this, Reservation.class);
                startActivity(gh);
                Toast.makeText(this, "Item 1 is clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menuItem2:
                Intent kl = new Intent(this, com.example.alonzo_carsakto.View.class);
                startActivity(kl);
                Toast.makeText(this, "Item 2 is clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menuItem3:
                Intent op = new Intent(this, About.class);
                startActivity(op);
                Toast.makeText(this, "Item 3 is clicked", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}