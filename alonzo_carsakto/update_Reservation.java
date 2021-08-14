package com.example.alonzo_carsakto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import javax.microedition.khronos.egl.EGLDisplay;

public class update_Reservation extends AppCompatActivity {

    EditText resid, ffdestination, ttdestination, manyy, datee, timee, carr;
    Button save;
    RadioButton rbutton;
    RadioGroup radGrou;
    DbHelper pok;
    reservationDetails lop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update__reservation);

        resid = (EditText) findViewById(R.id.txtID);
        ffdestination = (EditText) findViewById(R.id.txtFromm);
        ttdestination = (EditText) findViewById(R.id.txtToo);
        manyy = (EditText) findViewById(R.id.txtNumberr);
        datee = (EditText) findViewById(R.id.txtDatee);
        timee = (EditText) findViewById(R.id.txtTimee);

        radGrou = (RadioGroup) findViewById(R.id.rad_groupp);

        save = (Button) findViewById(R.id.btnOkayy);
        Intent intent = new Intent(this, View.class);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int radioId = radGrou.getCheckedRadioButtonId();

                rbutton = findViewById(radioId);

                int reservationiid = Integer.parseInt(resid.getText().toString());
               String fromDestination =  ffdestination.getText().toString();
               String toDestination = ttdestination.getText().toString();
               String many = manyy.getText().toString();
               String date = datee.getText().toString();
               String time = timee.getText().toString();

               //String car = rbutton.getText().toString();

                DbHelper pok = new DbHelper(update_Reservation.this);
                pok.updateReservation(reservationiid,fromDestination,toDestination,many,date,time,rbutton.getText().toString());
                Toast.makeText(update_Reservation.this, "Updated Data", Toast.LENGTH_SHORT).show();

                startActivity(intent);
            }
        });
    }
    public void checkButton(View view) {

        int radioId = radGrou.getCheckedRadioButtonId();

        rbutton = findViewById(radioId);
    }
}