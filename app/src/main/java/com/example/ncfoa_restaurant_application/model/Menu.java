package com.example.ncfoa_restaurant_application.model;

import java.util.List;

public class Menu {
    private Integer id;
    private String title;
    private String description;
    private List<Item> menuItems;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Item> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(List<Item> menuItems) {
        this.menuItems = menuItems;
    }
    public boolean addMenuItem(Item item){
        if (menuItems.contains(item))
            return false;
        menuItems.add(item);
        return true;
    }
}
