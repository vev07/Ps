package de.telran.lesson3.domain_layer.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CommonCustomer implements Customer {

    private int id;
    private String name;
    private Cart cart;
}