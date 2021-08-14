package com.example.alonzomobileapp;

public class OvernightPackage extends Package {
    private double addFee = 250.50;

    public OvernightPackage(String sname, String saddress, String rname, String raddress, double weight, double cost){
        super(sname,saddress,rname,raddress,weight,cost);
    }

    public OvernightPackage(String sname, String saddress, String rname, String raddress, double weight, double cost, double addFee){
        super(sname,saddress,rname,raddress,weight,cost);
        this.addFee = addFee;
    }

    public void setAddFee(double addFee) {
        this.addFee = addFee;
    }

    public double getAddFee() {
        return addFee;
    }

    public double calculateCost(){
        double addFee = getAddFee() + (getWeight() * getCost());
        return addFee;
    }

    @Override
    public void display() {

    }

    public String toString(){

        return "Type of Package: Overnight Package"+"\n"+"Sender Name:" + getSenderN() +"\n"+ "Sender Address:" + getSenderA() +"\n"+ "Receiver Name:" + getReceiverN() +"\n"+ "Receiver Address:" + getReceiverA() +"\n"+ "Weight:" +getWeight() +"\n"+ "Cost:" + getCost()+"\n"+ "Total:" + this.calculateCost();
    }
}
