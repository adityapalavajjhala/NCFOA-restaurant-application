package com.example.ncfoa_restaurant_application.admin.model;

public class Dish {
    String dishname;
    long price;
    String description;
    String purl;
    String type;
    long quantity;
    String dishid;

    public Dish(){

    }

    public Dish(String dishname, long price, String description, String purl, String type,long quantity,String dishid) {
        this.dishname = dishname;
        this.price = price;
        this.description= description;
        this.purl= purl;
        this.type= type;
        this.quantity=quantity;
        this.dishid=dishid;
    }

    public String getDishName() {
        return dishname;
    }

    public void setDishName(String dishName) {
        this.dishname = dishName;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPurl() {
        return purl;
    }

    public void setPurl(String purl) {
        this.purl = purl;
    }

    public String getType(){ return type;}

    public void setType(String type) { this.type = type;}

    public long getQuantity(){ return quantity;}

    public void setQuantity(long type) { this.quantity = quantity;}

    public String getDishid(){ return dishid;}

    public void setDishid(String type) { this.dishid = dishid;}


}
