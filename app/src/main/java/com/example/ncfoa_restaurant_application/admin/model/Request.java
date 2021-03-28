package com.example.ncfoa_restaurant_application.admin.model;

import java.util.List;

public class Request {
    private String usernumber;
    private String username;
    private String status;
    private String table;
    private List<Dish> foods; //list of food orders

    public  Request()
    {

    }

    public Request(String usernumber, String username, List<Dish> foods,String table,String status) {
        this.usernumber = usernumber;
        this.username = username;
        this.foods = foods;
        this.table= table;
        this.status = status; //Default is : Placed, 1: Prepared , 2: Delivered
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPhone() {
        return usernumber;
    }

    public void setPhone(String usernumber) {
        this.usernumber = usernumber;
    }

    public String getName() {
        return username;
    }

    public void setName(String username) {
        this.username = username;
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

    public void setTable(String table) {
            this.table = table;
    }


}

