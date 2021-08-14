package com.example.alonzomobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity1 extends AppCompatActivity  implements View.OnClickListener {

    Button btnPackage, btnTwoDay, btnOver, btnCalculate;
    EditText  txtSenderName, txtSenderAddress, txtReceiverName, txtReceiverAddress, txtWeight, txtCost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        btnTwoDay = (Button) findViewById(R.id.btnTwoDay);
        btnOver = (Button) findViewById(R.id.btnOver);
        btnCalculate = (Button) findViewById(R.id.btnCalculate);

       // txtPackage = (EditText) findViewById(R.id.txtPackage);
        txtSenderName = (EditText) findViewById(R.id.txtSender);
        txtSenderAddress = (EditText) findViewById(R.id.txtSAddress);
        txtReceiverName = (EditText) findViewById(R.id.txtReceiver);
        txtReceiverAddress = (EditText) findViewById(R.id.txtRAddress);
        txtWeight = (EditText) findViewById(R.id.txtWeight);
        txtCost = (EditText) findViewById(R.id.txtCost);



        //btnPackage.setOnClickListener(this);
        btnTwoDay.setOnClickListener(this);
        btnOver.setOnClickListener(this);
        //btnCalculate.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        DecimalFormat df = new DecimalFormat("#.##");
        String sn = String.valueOf(txtSenderName.getText());
        String sa = String.valueOf(txtSenderAddress.getText());
        String rn = String.valueOf(txtReceiverName.getText());
        String ra = String.valueOf(txtReceiverAddress.getText());
        double weight = Double.parseDouble(String.valueOf(txtWeight.getText()));
        double cost = Double.parseDouble(String.valueOf(txtCost.getText()));


        switch (v.getId()) {

            case R.id.btnTwoDay:
                //txtPackage.setText(btnTwoDay.getText());
                TwoDayPackage tw = new TwoDayPackage(sn,sa,rn,ra,weight, cost );
                double gh = tw.calculateCost();
                String fg =  df.format(gh);
                String dis = tw.toString();
                Toast.makeText(this,dis , Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnOver:
                //txtPackage.setText("Overnight Package");
                OvernightPackage ov = new OvernightPackage(sn,sa,rn,ra,weight, cost );
                double uyi = ov.calculateCost();
                String jh = df.format(uyi);
                String play = String.valueOf(ov.toString());
                Toast.makeText(this, play, Toast.LENGTH_SHORT).show();
                break;


        }


    }
}