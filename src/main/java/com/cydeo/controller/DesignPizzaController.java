package com.cydeo.controller;

import com.cydeo.bootstrap.DataGenerator;
import com.cydeo.model.Pizza;
import com.cydeo.repository.PizzaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.UUID;

@Controller

public class DesignPizzaController {

    private final PizzaRepository pizzaRepository;
    private final Pizza pizza;

    public DesignPizzaController(PizzaRepository pizzaRepository, Pizza pizza) {
        this.pizzaRepository = pizzaRepository;
        this.pizza = pizza;
    }

    @GetMapping("/design")
    public String showDesignForm(Model model) {

        model.addAttribute("pizza", pizza);
        model.addAttribute("cheeses", DataGenerator.cheeseTypeList);
        model.addAttribute("sauces", DataGenerator.sauceTypeList);
        model.addAttribute("toppings", DataGenerator.toppingTypeList);

        return "/design";

    }

    @PostMapping("/createPizza")
    public String processPizza(@ModelAttribute Pizza pizza) {

        pizza.setId(UUID.randomUUID());
        pizzaRepository.createPizza(pizza);

//        return "redirect:/orders/current?pizzaId=" + pizza.getId();
        return "redirect:/order";
    }

    @GetMapping("/order")
    public String orderForm(){
        return "/orderForm";
    }

}
