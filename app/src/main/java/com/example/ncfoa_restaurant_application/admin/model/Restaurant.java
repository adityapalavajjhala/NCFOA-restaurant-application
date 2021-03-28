package com.example.ncfoa_restaurant_application.admin.model;

import java.util.List;

// the Restaurant model class

public class Restaurant {

    public String fullName;
    public  String email;
    public String tablecount;
    List<Category> menu;
    List<Request> orders;

    public Restaurant(){

    }

    public Restaurant(String fullName,String email,String tablecount,List<Category>menu,List<Request>orders){
        this.fullName=fullName;
        this.email=email;
        this.menu=menu;
        this.tablecount=tablecount;
        this.menu=menu;
        this.orders=orders;
    }


    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Category> getCategory() {
        return menu;
    }

    public void getCategory(List<Category> menu) {
        this.menu = menu;
    }

    public List<Request> getOrders() {
        return orders;
    }

    public void setOrders(List<Request> orders) {
        this.orders = orders;
    }

    public String getTablecount() {
        return tablecount;
    }

    public void getTablecount(String  tablecount) {
        this.tablecount = tablecount;
    }
}
