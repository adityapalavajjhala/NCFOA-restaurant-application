package com.example.ncfoa_restaurant_application.admin;

public class model {
    String dishname;
    String price;
    String description;
    String purl;
    String type;

    public model(){

    }

    public model(String dishname, String price, String description, String purl,String type) {
        this.dishname = dishname;
        this.price = price;
        this.description= description;
        this.purl= purl;
        this.type= type;
    }

    public String getDishName() {
        return dishname;
    }

    public void setDishName(String dishName) {
        this.dishname = dishName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
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
}
