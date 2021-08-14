package com.example.alonzomobileapp;

public class OvernightPackage extends Package {
        private double addFee = 150;


        public OvernightPackage(String senderAdd,String receiverAdd, double weight, double cost){
            super(senderAdd, receiverAdd, weight,cost);
        }
        public OvernightPackage(String senderAdd,String receiverAdd, double weight, double cost, double addFee){
            super(senderAdd, receiverAdd, weight,cost);
            this.addFee = addFee;
        }
        public void setAddFee(double addFee){
            this.addFee = addFee;
        }
        public double getAddFee(){
            return addFee;
        }
        @Override
        public double calculateCost(){
            double adFee = addFee + (getWeight() * getCost());
            return adFee;
        }
}
