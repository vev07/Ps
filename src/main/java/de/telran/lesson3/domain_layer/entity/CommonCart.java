package de.telran.lesson3.domain_layer.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CommonCart implements Cart {

    private List<Product> products = new ArrayList<>();

    @Override
    public void addProduct(Product product) {
        products.add(product);
    }

    @Override
    public double getTotalPrice() {
        return products.stream().mapToDouble(Product::getPrice).reduce(Double::sum).orElse(0);
    }
}