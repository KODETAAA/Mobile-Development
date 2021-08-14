package com.example.alonzomobileapp;

public abstract class Package extends MainActivity1 {
    private String SenderN;
    private String SenderA;
    private String ReceiverN;
    private String ReceiverA;
    private double weight;
    private double cost;

    public Package(){

    }
    public Package(String sname,String saddress,String rname, String raddress, double weight, double cost){
        this.SenderN = sname;
        this.SenderA = saddress;
        this.ReceiverN = rname;
        this.ReceiverA = raddress;
        this.weight = weight;
        this.cost = cost;

    }

    public void setSenderN(String senderN) {
        SenderN = senderN;
    }

    public String getSenderN() {
        return SenderN;
    }

    public void setSenderA(String senderA) {
        SenderA = senderA;
    }

    public String getSenderA() {
        return SenderA;
    }

    public void setReceiverN(String receiverN) {
        ReceiverN = receiverN;
    }
    public String getReceiverN() {
        return ReceiverN;
    }

    public void setReceiverA(String receiverA) {
        ReceiverA = receiverA;
    }

    public String getReceiverA() {
        return ReceiverA;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getCost() {
        return cost;
    }

    public abstract void display();


    public abstract double calculateCost();


    /*public String Display(){
        return "Sender:"+txtSenderName.getText() + "Sender Address:" + txtSenderAddress.getText() + "Receiver Name:" + txtReceiverName.getText() +"Receiver Address:"  + txtReceiverAddress.getText() + "Weight" + txtWeight.getText() + "Cost:" +txtCost.getText();
    }

    Button btnPackage, btnOneDay, btnOver, btnCalculate;
    EditText txtPackage, txtSenderName, txtSenderAddress, txtReceiverName, txtReceiverAddress, txtWeight, txtCost ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_package);

        btnPackage= (Button) findViewById(R.id.btnPackage);
        btnOneDay = (Button) findViewById(R.id.btnOneDay);
        btnOver = (Button) findViewById(R.id.btnOver);
        btnCalculate = (Button) findViewById(R.id.btnCalculate);

        txtPackage = (EditText) findViewById(R.id.txtPackage);
        txtSenderName = (EditText) findViewById(R.id.txtSender);
        txtSenderAddress = (EditText) findViewById(R.id.txtSAddress);
        txtReceiverName = (EditText) findViewById(R.id.txtReceiver);
        txtReceiverAddress = (EditText) findViewById(R.id.txtRAddress);
        txtWeight = (EditText) findViewById(R.id.txtWeight);
        txtCost = (EditText) findViewById(R.id.txtCost);


        btnPackage.setOnClickListener(this);
        btnOneDay.setOnClickListener(this);
        btnOver.setOnClickListener(this);
        btnCalculate.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        DecimalFormat df = new DecimalFormat("#.##");
        String sn = txtSenderName.getText().toString();
        String sa = txtSenderAddress.getText().toString();
        String rn = txtReceiverName.getText().toString();
        String ra = txtReceiverAddress.getText().toString();
        double weight = Double.parseDouble( String.valueOf(txtWeight.getText()));
        double cost = Double.parseDouble(String.valueOf(txtCost.getText()));


        switch(v.getId()){
            case R.id.btnPackage:
                txtPackage.setText("Package");
                break;
            case R.id.btnOneDay:
                txtPackage.setText("OneDay Package");
                break;
            case R.id.btnOver:
                txtPackage.setText("Overnight Package");
                break;
            case R.id.btnCalculate:

                if(txtPackage.getText().equals("OneDay Package")){
                    TwoDayPackage td = new TwoDayPackage(sn,sa,rn,ra,weight,cost,150.50);
                   double CostA = td.calculateCost();
                   txtCost.setText(String.valueOf(df.format(CostA)));

                }else if(txtPackage.getText().equals("Overnight Package")){
                    OvernightPackage po = new OvernightPackage(sn,sa,rn,ra,weight,cost,250.50);
                    double CostB = po.calculateCost();
                    txtCost.setText(String.valueOf(df.format(CostB)));
                }




        }




    }*/

}