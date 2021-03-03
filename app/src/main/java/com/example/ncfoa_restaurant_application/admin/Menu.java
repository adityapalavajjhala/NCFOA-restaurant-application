package com.example.ncfoa_restaurant_application.admin;

public class Menu {
    private String dishName;
    String type;
    String price;

    public Menu(String dishName, String type, String price) {
        this.dishName = dishName;
        this.type = type;
        this.price = price;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
