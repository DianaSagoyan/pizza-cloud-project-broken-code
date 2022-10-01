package com.cydeo.controller;

import com.cydeo.bootstrap.DataGenerator;
import com.cydeo.model.Pizza;
import com.cydeo.repository.PizzaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final PizzaRepository pizzaRepository;
    private final Pizza pizza;

    public HomeController(PizzaRepository pizzaRepository, Pizza pizza) {
        this.pizzaRepository = pizzaRepository;
        this.pizza = pizza;
    }
    @GetMapping
    public String homePage(){

        return "/home";
    }

    @GetMapping("/design")
    public String designPage(Model model){

        model.addAttribute("pizza", pizza);
        model.addAttribute("cheeses", DataGenerator.cheeseTypeList);
        model.addAttribute("sauces", DataGenerator.sauceTypeList);
        model.addAttribute("toppings", DataGenerator.toppingTypeList);

        return "/design";
    }
}
