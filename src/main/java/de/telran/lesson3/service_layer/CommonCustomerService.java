package de.telran.lesson3.service_layer;

import de.telran.lesson3.domain_layer.entity.Cart;
import de.telran.lesson3.domain_layer.entity.Customer;
import de.telran.lesson3.repository_layer.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CommonCustomerService implements CustomerService {

    @Autowired
    private CustomerRepository repository;

    @Autowired
    private ProductService productService;

    @Override
    public List<Customer> getAll() {
        return repository.getAll();
    }

    @Override
    public Customer getById(int id) {
        return repository.getById(id);
    }

    @Override
    public void add(Customer customer) {
        repository.add(customer.getName());
    }

    @Override
    public void deleteById(int id) {
        repository.delete(id);
    }

    @Override
    public void deleteByName(String name) {
        int idToDelete = repository.getAll().stream().filter(x -> x.getName().equals(name)).findFirst().get().getId();
        repository.delete(idToDelete);
    }

    @Override
    public int getCount() {
        return repository.getAll().size();
    }

    @Override
    public double getTotalPriceById(int id) {
        return repository.getById(id).getCart().getTotalPrice();
    }

    @Override
    public double getAveragePriceById(int id) {
        Cart cart = repository.getById(id).getCart();
        return cart.getTotalPrice() / cart.getProducts().size();
    }

    @Override
    public void addToCartById(int customerId, int productId) {
        repository.addToCartById(customerId, productId);
    }

    @Override
    public void deleteFromCart(int customerId, int productId) {
        repository.deleteFromCart(customerId, productId);
    }

    @Override
    public void clearCart(int customerId) {
        repository.clearCart(customerId);
    }
}