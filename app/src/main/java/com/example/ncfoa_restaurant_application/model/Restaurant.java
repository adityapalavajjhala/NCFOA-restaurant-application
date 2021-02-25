package com.example.ncfoa_restaurant_application.model;

import java.util.Map;
import java.util.TreeMap;

public class Restaurant {
    private Integer id;
    private String name,address,city,email,message;
    private Boolean status,active;
    private Map<String,Menu> menus;


    public void setMenus(Map<String, Menu> menus) {
        this.menus = menus;
    }

    public Map<String,Menu> getMenus() {
        return menus;
    }

    public boolean addMenus(String name,Menu menu){
        if(menus==null
                ||menus.isEmpty())
            menus= new TreeMap<>();
        if(menus.containsKey(name)
                ||menus.containsValue(menu))
            return false;
        menus.put(name,menu);
        return true;
    }


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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
