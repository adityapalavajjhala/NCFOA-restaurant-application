package com.example.ncfoa_restaurant_application.admin.model;

public class User {

    private String Name;
    private String Phone;

    public User() {

    }

    public User(String name, String phone) {
        Name = name;
        Phone = phone;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        this.Phone = phone;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }


}
