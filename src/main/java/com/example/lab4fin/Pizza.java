package com.example.lab4fin;

import java.util.List;

public class Pizza {
    private Long id;

    private Long Prise;
    private String name;
    private List<String> toppings;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getToppings() {
        return toppings;
    }

    public void setToppings(List<String> toppings) {
        this.toppings = toppings;
    }

    public double getPrice() {
        return Prise;
    }
}
