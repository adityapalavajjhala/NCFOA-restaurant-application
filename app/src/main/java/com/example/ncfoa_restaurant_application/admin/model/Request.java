package com.example.ncfoa_restaurant_application.admin.model;

import java.util.List;

public class Request {
    private String phone;
    private String name;
    private String status;
    private String table;
    private List<Dish> foods; //list of food orders

    public Request() {
    }

    public Request(String phone, String name, List<Dish> foods,String table,String status) {
        this.phone = phone;
        this.name = name;
        this.foods = foods;
        this.table= table;
        this.status = status; //Default is 0, 0: Placed, 1: Preparing , 2: Delivered
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Dish> getFoods() {
        return foods;
    }

    public void setFoods(List<Dish> foods) {
        this.foods = foods;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String  table) {
            this.table = table;
    }


}

