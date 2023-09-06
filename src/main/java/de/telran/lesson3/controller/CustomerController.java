package de.telran.lesson3.controller;

import de.telran.lesson3.domain_layer.entity.CommonCustomer;
import de.telran.lesson3.domain_layer.entity.Customer;
import de.telran.lesson3.service_layer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @GetMapping
    public List<Customer> getAll() {
        return customerService.getAll();
    }
    @GetMapping("/{id}")
    public Customer get_by_id(@PathVariable int id) {
        return customerService.getById(id);
    }

    @PostMapping
    public void add(@RequestBody CommonCustomer customer) {
        customerService.add(customer);
    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id) {
        customerService.deleteById(id);
    }
    @DeleteMapping("/delete_by_name/{name}")
    public void deleteByName(@PathVariable String name) {
        customerService.deleteByName(name);
    }
    @GetMapping("/get_count")
    public int getCount() {
        return customerService.getCount();
    }
    @GetMapping("/get_total_price_by_id/{id}")
    public double getTotalPriceById(@PathVariable int id) {
        return customerService.getTotalPriceById(id);
    }
    @GetMapping("/get_average_price_by_id/{id}")
    public double getAveragePriceById(@PathVariable int id) {
        return customerService.getAveragePriceById(id);
    }
    @PatchMapping("/add_to_cart_by_id/{customerId}/{productId}")
    public void addToCartById(@PathVariable int customerId, @PathVariable int productId) {
      customerService.addToCartById(customerId,productId);
    }
    @DeleteMapping("/delete_from_cart/{customerId}/{productId}")
    public void deleteFromCart(@PathVariable int customerId, @PathVariable int productId) {
        customerService.deleteFromCart(customerId, productId);
    }
    @DeleteMapping("/clear_cart/{customerId}")
    public void clearCart(@PathVariable int customerId) {
        customerService.clearCart(customerId);
    }

}
