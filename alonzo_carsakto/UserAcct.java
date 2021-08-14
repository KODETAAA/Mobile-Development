package com.example.alonzo_carsakto;

public class UserAcct {

    private int id;
    private String fname;
    private String pass;
    private String email;
    private String contact;

    public UserAcct() {
    }

    public UserAcct(int id, String fname, String pass, String email, String contact) {
        this.id = id;
        this.fname = fname;
        this.pass = pass;
        this.email = email;
        this.contact = contact;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "UserAcct{" +
                "id=" + id +
                ", fname='" + fname + '\'' +
                ", pass='" + pass + '\'' +
                ", email='" + email + '\'' +
                ", contact='" + contact + '\'' +
                '}';
    }
}
