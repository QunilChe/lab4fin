package com.example.lab4fin;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class PizzaRepository implements CrudRepository<Pizza, Long> {

    private final Map<Long, Pizza> pizzaDatabase = new HashMap<>();

    @Override
    public Pizza save(Pizza pizza) {
        if (pizza.getId() == null) {
            // Якщо у піци немає ідентифікатора, генеруємо його
            pizza.setId(generateId());
        }
        pizzaDatabase.put(pizza.getId(), pizza);
        return pizza;
    }

    @Override
    public Pizza findById(Long id) {
        return pizzaDatabase.get(id);
    }

    @Override
    public void deleteById(Long id) {
        pizzaDatabase.remove(id);
    }

    // Інші методи CRUD

    private Long generateId() {
        // Логіка генерації нового ідентифікатора (наприклад, може бути залежно від поточного часу)
        // Це приклад, і ви можете вибрати інший спосіб генерації ідентифікатора
        return System.currentTimeMillis();
    }
    @Override
    public List<Pizza> findAll() {
        return new ArrayList<>(pizzaDatabase.values());
    }
}
