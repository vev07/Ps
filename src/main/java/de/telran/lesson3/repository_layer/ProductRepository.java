package de.telran.lesson3.repository_layer;

import de.telran.lesson3.domain_layer.entity.Product;

import java.util.List;

public interface ProductRepository {

    List<Product> getAll();

    Product getById(int id);

    void add(String name, double price);

    void delete(int id);

  }