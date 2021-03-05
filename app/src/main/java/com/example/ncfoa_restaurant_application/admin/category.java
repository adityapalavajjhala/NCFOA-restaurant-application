package com.example.ncfoa_restaurant_application.admin;

public class category {

    String categoryName;

    public category()
    {

    }

    public category(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

}