package com.example.lab4fin;

import org.springframework.stereotype.Service;

@Service
public class OrderService {
    public void addToCart(ShoppingCart cart, Pizza pizza) {
        cart.addPizza(pizza);
    }

    public void placeOrder(ShoppingCart cart) {
        // Логіка для підтвердження та обробки замовлення
        if (cart.getPizzas().isEmpty()) {
            System.out.println("Корзина порожня. Неможливо оформити замовлення.");
            return;
        }

        System.out.println("Замовлення прийнято:");

        for (Pizza pizza : cart.getPizzas()) {
            System.out.println("- " + pizza.getName() + " з топінгами: " + pizza.getToppings());
        }

        System.out.println("Замовлення успішно оформлено!");
        // Тут може бути додаткова логіка для обробки замовлення, наприклад, вивід чека, відправка на кухню і т.д.

        // Після оформлення замовлення очищаємо корзину
        cart.clear();
    }
    public void confirmOrder(ShoppingCart cart) {
        // Ваша логіка для підтвердження замовлення
        // Наприклад, ви можете зберігати замовлення у базі даних або в іншому місці.

        // Приклад: виведення інформації про замовлення та обчислення загальної вартості
        System.out.println("Order confirmed:");
        for (Pizza pizza : cart.getPizzas()) {
            System.out.println("Pizza ID: " + pizza.getId() + ", Name: " + pizza.getName());
        }
        double totalPrice = calculateTotalPrice(cart);
        System.out.println("Total Price: " + totalPrice);
    }

    private double calculateTotalPrice(ShoppingCart cart) {
        // Ваша логіка для обчислення загальної вартості замовлення
        // Наприклад, додати ціни усіх піц у корзині

        double totalPrice = 0.0;
        for (Pizza pizza : cart.getPizzas()) {
            // Припустимо, що у кожної піци є поле price
            totalPrice += pizza.getPrice();
        }

        return totalPrice;
    }
}