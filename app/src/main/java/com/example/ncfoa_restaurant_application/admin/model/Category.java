package com.example.ncfoa_restaurant_application.admin.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Category {

    String categoryName;
    List<Dish>dishes;

    public Category()
    {

    }

    public Category(String categoryName,List<Dish>dishes)
    {
       this.categoryName=categoryName;
       this.dishes=dishes;

    }
    public List<Dish> getmap() {
        return dishes;
    }

    public void setmap(List<Dish>dishes) {
        this.dishes = dishes;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

}