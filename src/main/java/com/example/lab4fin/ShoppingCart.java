package com.example.lab4fin;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Pizza> pizzas = new ArrayList<>();

    public void addPizza(Pizza pizza) {
        pizzas.add(pizza);
    }

    public List<Pizza> getPizzas() {
        return pizzas;
    }

    public void clear() {
        pizzas.clear();
    }


}