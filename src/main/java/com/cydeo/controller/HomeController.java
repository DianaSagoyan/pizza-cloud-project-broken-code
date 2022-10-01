package com.cydeo.controller;

import com.cydeo.bootstrap.DataGenerator;
import com.cydeo.model.Pizza;
import com.cydeo.repository.PizzaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping
    public String homePage(){

        return "/home";
    }

}
