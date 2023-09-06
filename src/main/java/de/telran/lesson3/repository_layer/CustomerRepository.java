package de.telran.lesson3.repository_layer;

import de.telran.lesson3.domain_layer.entity.Customer;

import java.util.List;

public interface CustomerRepository {

    List<Customer> getAll();

    Customer getById(int id);

    void add(String name);

    void delete(int id);

    void addToCartById(int customerId, int productId);

    void deleteFromCart(int customerId, int productId);

    void clearCart(int customerId);
}