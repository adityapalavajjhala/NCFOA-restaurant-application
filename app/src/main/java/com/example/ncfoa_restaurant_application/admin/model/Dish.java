package com.example.ncfoa_restaurant_application.admin.model;

public class Dish {
    String dishid;
    String dishname;
    long price;
    long quantity;
    String type;


    public Dish()
    {

    }

    public Dish(String dishname, long price, String type,long quantity,String dishid) {
        this.dishid=dishid;
        this.dishname = dishname;
        this.price = price;
        this.type= type;
        this.quantity=quantity;

    }

    public String getDishName() {
        return dishname;
    }

    public void setDishName(String dishname) {
        this.dishname = dishname;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getType(){ return type;}

    public void setType(String type) { this.type = type;}

    public long getQuantity(){ return quantity;}

    public void setQuantity(long quantity) {this.quantity= quantity; }

    public String getDishid(){ return dishid;}

    public void setDishid(String type) { this.dishid = dishid;}


}
