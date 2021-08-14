package com.example.alonzomobileapp;

import android.widget.Toast;

public class TwoDayPackage extends Package {
    private double fee = 150.50;

    public TwoDayPackage(String sname, String saddress, String rname, String raddress, double weight, double cost) {
        super(sname, saddress, rname, raddress, weight, cost);
    }

    public TwoDayPackage(String sname, String saddress, String rname, String raddress, double weight,double cost,double fee) {
        super(sname, saddress, rname, raddress, weight, cost);
        this.fee = fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    public double getFee() {
        return fee;
    }

    public  double calculateCost() {
        double fee = getWeight() * getCost() + getFee();
        return fee;
    }

    @Override
    public void display() {
        System.out.println("Sender Name:" + getSenderN());
        System.out.println("Sender Address:" + getSenderA());
        System.out.println("Receiver Name:" + getReceiverN());
        System.out.println("Receiver Address:" + getReceiverA());
        System.out.println("Weight:" +getWeight());
        System.out.println("Cost:" + getCost());
    }

    public String toString(){
        return "Type of Package: TwoDay Package" +"\n"+ "Sender Name:" + getSenderN() +"\n"+ "Sender Address:" + getSenderA() +"\n"+ "Receiver Name:" + getReceiverN() +"\n"+ "Receiver Address:" + getReceiverA() +"\n"+ "Weight:" +getWeight() +"\n"+ "Cost:" + getCost() +"\n"+"Total:" + this.calculateCost();

    }



}
