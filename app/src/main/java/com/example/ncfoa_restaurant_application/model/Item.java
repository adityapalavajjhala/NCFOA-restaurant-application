package com.example.ncfoa_restaurant_application.model;

public class Item {
    private Integer id;
    private String name;
    private String description;
    private Double price;

    public Boolean getAvailabe() {
        return availabe;
    }

    public void setAvailabe(Boolean availabe) {
        this.availabe = availabe;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    private Boolean availabe;
    private Integer rating;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
