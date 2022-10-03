package com.cydeo.converter;

import com.cydeo.repository.PizzaRepository;
import org.springframework.core.convert.converter.Converter;

import java.util.UUID;

public class UuidConverter implements Converter<String, UUID> {

    public final PizzaRepository pizzaRepository;

    public UuidConverter(PizzaRepository pizzaRepository) {
        this.pizzaRepository = pizzaRepository;
    }


    @Override
    public UUID convert(String source) {
        return UUID.fromString(source);
    }
}
