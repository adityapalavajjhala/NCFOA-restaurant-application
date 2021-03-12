package com.example.ncfoa_restaurant_application.admin;

import java.util.ArrayList;
import java.util.List;

public class Category {

    String categoryName;
    List<Dish> dishes;

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }

    public Category()
    {
        categoryName="";
        dishes=new ArrayList<>();
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

}