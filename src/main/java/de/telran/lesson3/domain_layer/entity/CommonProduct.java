package de.telran.lesson3.domain_layer.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
public class CommonProduct implements Product {

    private int id;
    private String name;
    private double price;

}