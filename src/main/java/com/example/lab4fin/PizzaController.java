package com.example.lab4fin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pizza")
public class PizzaController {

    private final PizzaRepository pizzaRepository;
    private final OrderService orderService;

    @Autowired
    public PizzaController(PizzaRepository pizzaRepository, OrderService orderService) {
        this.pizzaRepository = pizzaRepository;
        this.orderService = orderService;
    }

    @GetMapping("/get/{pizzaId}")
    public Pizza getPizza(@PathVariable Long pizzaId) {
        return pizzaRepository.findById(pizzaId);
    }

    @PostMapping("/add-ingredient/{pizzaId}")
    public void addIngredientToPizza(@PathVariable Long pizzaId, @RequestBody String ingredient) {
        Pizza pizza = pizzaRepository.findById(pizzaId);
        if (pizza != null) {
            pizza.getToppings().add(ingredient);
            pizzaRepository.save(pizza);
        }
    }

    @GetMapping("/get-all-pizzas")
    public List<Pizza> getAllPizzas() {
        return pizzaRepository.findAll();
    }

    @PostMapping("/add-to-cart/{pizzaId}")
    public void addToCart(@PathVariable Long pizzaId, @RequestBody ShoppingCart cart) {
        Pizza pizza = pizzaRepository.findById(pizzaId);
        orderService.addToCart(cart, pizza);
    }

    @PostMapping("/place-order")
    public void placeOrder(@RequestBody ShoppingCart cart) {
        orderService.placeOrder(cart);
    }
    @PostMapping("/confirm-order")
    public void confirmOrder(@RequestBody ShoppingCart cart) {
        orderService.confirmOrder(cart);
    }

}
