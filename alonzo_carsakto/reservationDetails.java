package com.example.alonzo_carsakto;

public class reservationDetails {

    private int id;
    private String fromDestination;
    private String toDestination;
    private String Many;
    private String Date;
    private String Time;
    private String Vehicle;

    public reservationDetails() {
    }

    public reservationDetails(int id, String fromDestination, String toDestination, String many, String date, String time, String vehicle) {
        this.id = id;
        this.fromDestination = fromDestination;
        this.toDestination = toDestination;
        this.Many = many;
        this.Date = date;
        this.Time = time;
        this.Vehicle = vehicle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFromDestination() {
        return fromDestination;
    }

    public void setFromDestination(String fromDestination) {
        this.fromDestination = fromDestination;
    }

    public String getToDestination() {
        return toDestination;
    }

    public void setToDestination(String toDestination) {
        this.toDestination = toDestination;
    }

    public String getMany() {
        return Many;
    }

    public void setMany(String many) {
        this.Many = many;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        this.Date = date;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        this.Time = time;
    }

    public String getVehicle() {
        return Vehicle;
    }

    public void setVehicle(String vehicle) {
        this.Vehicle = vehicle;
    }

    @Override
    public String toString() {
        return "ReservationID = " + getId()+ "\n" + "From Where = " + getFromDestination() + "\n" + "To where = " + getToDestination() + "\n" + "How Many = " + getMany() + "\n" + "Date = " + getDate() + "\n" + "Time = " + getTime() + "\n" + "Vehicle =  " + getVehicle() + "\n";
    }
}
