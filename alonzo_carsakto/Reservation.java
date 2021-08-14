package com.example.alonzo_carsakto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Reservation extends AppCompatActivity {
    RadioButton rbutton;
    RadioGroup radGroup;
    EditText desto,desfrom, numofppl, date,time,vehicle;
    //Button okay;
    DbHelper kj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation);
        kj = new DbHelper(this);

        desfrom = (EditText) findViewById(R.id.txtFrom);
        desto = (EditText) findViewById(R.id.txtTo);
        numofppl = (EditText) findViewById(R.id.txtNumber);
        date = (EditText) findViewById(R.id.txtDate);
        time = (EditText) findViewById(R.id.txtTime);

        radGroup = (RadioGroup) findViewById(R.id.rad_group);

        Button okay = (Button) findViewById(R.id.btnOkay);
        okay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int radioId = radGroup.getCheckedRadioButtonId();
                rbutton = findViewById(radioId);
                reservationDetails qwer;

                try{
                    qwer = new reservationDetails(-1, desfrom.getText().toString(), desto.getText().toString(), numofppl.getText().toString(), date.getText().toString(), time.getText().toString(), rbutton.getText().toString() );
                    boolean lop = kj.addReservation(qwer);
                    Toast.makeText(Reservation.this, "Data Inserted" +lop , Toast.LENGTH_SHORT).show();
                }catch (Exception e){
                    Toast.makeText(Reservation.this, "Reservation NOT made!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    public void checkButton(View view) {

        int radioId = radGroup.getCheckedRadioButtonId();

        rbutton = findViewById(radioId);
    }
}