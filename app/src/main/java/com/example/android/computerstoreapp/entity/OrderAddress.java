package com.example.android.computerstoreapp.entity;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;

public class OrderAddress extends DataSupport {
    private String fullname;
    private String address1;
    private String address2;
    private String city;
    private String state;
    private String zip;
    private String phonenumber;
    private String email;

    public OrderAddress(ArrayList<String> params) {
        this.fullname = params.get(0);
        this.address1 = params.get(1);
        this.address2 = params.get(2);
        this.city = params.get(3);
        this.state = params.get(4);
        this.zip = params.get(5);
        this.phonenumber = params.get(6);
        this.email = params.get(7);
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "OrderAddress{" +
                "fullname='" + fullname + '\'' +
                ", address1='" + address1 + '\'' +
                ", address2='" + address2 + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip='" + zip + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
