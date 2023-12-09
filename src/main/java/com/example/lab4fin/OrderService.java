package com.example.lab4fin;

import org.springframework.stereotype.Service;

@Service
public class OrderService {
    public void addToCart(ShoppingCart cart, Pizza pizza) {
        cart.addPizza(pizza);
    }

    public void placeOrder(ShoppingCart cart) {
        if (cart.getPizzas().isEmpty()) {
            System.out.println("empty list.");
            return;
        }

        System.out.println("order get:");

        for (Pizza pizza : cart.getPizzas()) {
            System.out.println("- " + pizza.getName() + " topings: " + pizza.getToppings());
        }

        System.out.println("order comfirmed!");
        cart.clear();
    }
    public void confirmOrder(ShoppingCart cart) {
        System.out.println("Order confirmed:");
        for (Pizza pizza : cart.getPizzas()) {
            System.out.println("Pizza ID: " + pizza.getId() + ", Name: " + pizza.getName());
        }
        double totalPrice = calculateTotalPrice(cart);
        System.out.println("Total Price: " + totalPrice);
    }

    private double calculateTotalPrice(ShoppingCart cart) {
        double totalPrice = 0.0;
        for (Pizza pizza : cart.getPizzas()) {
            totalPrice += pizza.getPrice();
        }
        return totalPrice;
    }
}