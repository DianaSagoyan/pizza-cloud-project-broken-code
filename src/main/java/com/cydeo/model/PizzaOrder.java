package com.cydeo.model;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class PizzaOrder {

    private String deliveryName;
    private String deliveryStreet;
    private String deliveryCity;
    private String deliveryState;
    private String deliveryZip;
    private String ccNumber;
    private String ccExpiration;
    private String ccCVV;
    private Pizza pizza;

}
