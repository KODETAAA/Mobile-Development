package com.example.alonzomobileapp;

public class TwoDayPackage extends Package{
    private double flatFee = 90;
    public TwoDayPackage(String senderAdd,String receiverAdd, double weight, double cost){
        super(senderAdd, receiverAdd, weight,cost);
    }
    public TwoDayPackage(String senderAdd,String receiverAdd, double weight, double cost, double flatFee){
        super(senderAdd, receiverAdd, weight,cost);
        this.flatFee = flatFee;
    }
    public void setFlatFee(double flatFee){
        this.flatFee = flatFee;
    }
    public double getFlatFee(){
        return flatFee;
    }
    @Override
    public double calculateCost(){
        double fee = flatFee + (getWeight() * getCost());
        return fee;
    }
}
