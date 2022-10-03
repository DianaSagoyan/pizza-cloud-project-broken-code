package com.cydeo.controller;

import com.cydeo.bootstrap.DataGenerator;
import com.cydeo.model.Pizza;
import com.cydeo.model.PizzaOrder;
import com.cydeo.repository.PizzaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.UUID;

@Controller

public class DesignPizzaController {

    private final PizzaRepository pizzaRepository;
    private final Pizza pizza;
    private final PizzaOrder pizzaOrder;

    public DesignPizzaController(PizzaRepository pizzaRepository, Pizza pizza, PizzaOrder pizzaOrder) {
        this.pizzaRepository = pizzaRepository;
        this.pizza = pizza;
        this.pizzaOrder = pizzaOrder;
    }
    @GetMapping("/design")
    public String showDesignForm(Model model) {

        model.addAttribute("pizza", pizza);
        model.addAttribute("cheeses", DataGenerator.cheeseTypeList);
        model.addAttribute("sauces", DataGenerator.sauceTypeList);
        model.addAttribute("toppings", DataGenerator.toppingTypeList);

        return "/design";
    }
    @PostMapping("/current")
    public String processPizza(@ModelAttribute("pizza") Pizza pizza) {

        pizza.setId(UUID.randomUUID());
        pizzaRepository.createPizza(pizza);

        return "redirect:/orders/current?pizzaId=" + pizza.getId();
//        return "redirect:/order";
    }

    @GetMapping("/orders/current/{id}")
    public String orderForm(Model model, @PathVariable UUID id){
        model.addAttribute("pizzaOrder", pizzaOrder);
        return "/orderForm";
    }

}
