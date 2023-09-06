package de.telran.lesson3.domain_layer.entity;

import java.util.List;

public interface Cart {

    List<Product> getProducts();

    void addProduct(Product product);

    double getTotalPrice();
}