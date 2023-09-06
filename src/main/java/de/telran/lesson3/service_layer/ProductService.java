package de.telran.lesson3.service_layer;

import de.telran.lesson3.domain_layer.entity.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAll();

    Product getById(int id);

    void add(Product product);

    void deleteById(int id);

    void deleteByName(String name);

    int getCount();

    double getTotalPrice();

    double getAveragePrice();
}