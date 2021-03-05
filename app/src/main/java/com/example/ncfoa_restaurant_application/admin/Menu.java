package com.example.ncfoa_restaurant_application.admin;

public class Menu {
    private String dishName;
    String categoryName;
    String price;
    String description;
    String purl;

    public Menu(String dishName, String type, String price) {
        this.dishName = dishName;
        this.categoryName = type;
        this.price = price;
        this.description= description;
        this.purl= purl;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String type) {
        this.categoryName = categoryName;
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
}
