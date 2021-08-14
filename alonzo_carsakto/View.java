package com.example.alonzo_carsakto;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class View extends AppCompatActivity {

    ListView lv;
    ArrayAdapter adapter;
    Button save;
    DbHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        lv = (ListView) findViewById(R.id.lvData);

        save = (Button) findViewById(R.id.btnUpdate);

        db = new DbHelper(View.this);
        showReservationOnListView();

        save.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                Intent fdg = new Intent(View.this, update_Reservation.class);
                startActivity(fdg);
                //finish();
            }
        });

       lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

           @Override
           public boolean onItemLongClick(AdapterView<?> parent, android.view.View view, int position, long id) {
               reservationDetails gj = (reservationDetails) parent.getItemAtPosition(position);

               AlertDialog.Builder jk = new AlertDialog.Builder(View.this);
               jk.setIcon(android.R.drawable.ic_delete);
               jk.setTitle("Are you sure?");
               jk.setMessage("Do you want to delete this data?");

               jk.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialog, int which) {

                       db.deleteOne(gj);
                       showReservationOnListView();
                       Toast.makeText(View.this, "Deleted data", Toast.LENGTH_SHORT).show();
                   }
               });
                jk.setNegativeButton("No", null);
                jk.show();
               return true;
           }
       });
                }

    private void showReservationOnListView() {
        adapter = new ArrayAdapter<reservationDetails>(View.this, android.R.layout.simple_list_item_1,android.R.id.text1, db.getCar());
        lv.setAdapter(adapter);
    }


}



