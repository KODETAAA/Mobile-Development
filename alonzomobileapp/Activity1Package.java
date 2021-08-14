package com.example.alonzomobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DecimalFormat;

public class Activity1Package extends AppCompatActivity implements View.OnClickListener {
        Button btnOvernight, btnTwoDay;
        Button btnClear;
        EditText txtSAddress , txtRAddress, txtSenderS,txtReceiverS;
        EditText txtounce, txtCost , txtTotal;
        EditText edt;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_activity1_package);

            txtSenderS = (EditText) findViewById(R.id.txtSenderS);
            txtReceiverS = (EditText) findViewById(R.id.txtReceiverS);
            txtTotal = (EditText) findViewById(R.id.txtTotal);
            txtSAddress = (EditText) findViewById(R.id.txtSAddress);
            txtRAddress = (EditText) findViewById(R.id.txtRAddress);
            txtounce = (EditText) findViewById(R.id.txtounce);
            txtCost = (EditText) findViewById(R.id.txtCost);
            btnOvernight = (Button) findViewById(R.id.btnOvernight);
            btnTwoDay = (Button) findViewById(R.id.btnTwoDay);

            btnOvernight.setOnClickListener(this);
            btnTwoDay.setOnClickListener(this);
        }

        @Override
        public void onClick (View v){
            DecimalFormat df = new DecimalFormat("#.##");
            String senderAddress = String.valueOf(txtSAddress.getText());
            String receiverAddress = String.valueOf(txtRAddress.getText());
            double weight = Double.parseDouble(String.valueOf(txtounce.getText()));
            double cost = Integer.parseInt(String.valueOf(txtCost.getText()));
            edt = findViewById(R.id.edt);
            btnClear = findViewById(R.id.btnClear);
            btnClear.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    edt.getText().clear();
                }
            });
            switch(v.getId()){
                case R.id.btnTwoDay:
                    txtSenderS.setText(String.valueOf(senderAddress));
                    txtReceiverS.setText(String.valueOf(receiverAddress));

                    TwoDayPackage td = new TwoDayPackage(senderAddress,receiverAddress,weight,cost);
                    double tCost = td.calculateCost();
                    txtTotal.setText(String.valueOf(df.format(tCost)));
                    Toast.makeText(Activity1Package.this, "Two Day Package Fee is computed", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.btnOvernight:
                    txtSenderS.setText(String.valueOf(senderAddress));
                    txtReceiverS.setText(String.valueOf(receiverAddress));

                    OvernightPackage ovn = new OvernightPackage(senderAddress,receiverAddress,weight,cost);
                    tCost = ovn.calculateCost();
                    txtTotal.setText(String.valueOf(df.format(tCost)));
                    Toast.makeText(Activity1Package.this, "Over Night Package Fee is computed", Toast.LENGTH_SHORT).show();
                    break;

                default:
                    throw new IllegalStateException("Unexpected Value: "+v.getId());
            }
        }
}