package com.example.myapplication222;

public class User
{

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public User(String address, String city) {
        this.address = address;
        this.city = city;
    }

    private  String address;
    private String city;

}
