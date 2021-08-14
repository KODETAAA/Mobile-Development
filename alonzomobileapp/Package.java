package com.example.alonzomobileapp;

public abstract class Package {
    private String senderAdd;
    private String receiverAdd;
    private double weight;
    private double cost;

    public Package(String senderAdd,String receiverAdd, double weight, double cost){
        this.senderAdd = senderAdd;
        this.receiverAdd = receiverAdd;
        this.weight = weight;
        this.cost = cost;
    }
    public void setSenderAdd(String senderAdd){
        this.senderAdd = senderAdd;
    }
    public void setReceiverAdd(String receiverAdd){
        this.receiverAdd = receiverAdd;
    }
    public void setWeight(double weight){
        if(weight>0) {
            this.weight = weight;
        }
    }
    public void setCost(double cost){
        if(cost>0) {
            this.cost = cost;
        }
    }
    public String getSenderAdd(){
        return senderAdd;
    }
    public String getReceiverAdd(){
        return receiverAdd;
    }
    public double getWeight(){
        return weight;
    }
    public double getCost(){

        return cost;
    }

    public abstract double calculateCost();
}
