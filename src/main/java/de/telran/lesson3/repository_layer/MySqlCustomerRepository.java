package de.telran.lesson3.repository_layer;

import de.telran.lesson3.domain_layer.entity.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static de.telran.lesson3.domain_layer.database.MySqlConnector.getConnection;

public class MySqlCustomerRepository implements CustomerRepository {

    @Override
    public List<Customer> getAll() {
        try (Connection connection = getConnection()) {
            String query = "SELECT * FROM customer as c left join customer_product as cp on c.id = cp.customer_id left join product as p on cp.product_id = p.id;";
            ResultSet resultSet = connection.createStatement().executeQuery(query);
            List<Customer> result = new ArrayList<>();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                int productId = resultSet.getInt(5);
                String productName = resultSet.getString(7);
                double productPrice = resultSet.getDouble(8);
                CommonCart cart = new CommonCart();
                cart.addProduct(new CommonProduct(productId, productName,productPrice));
                result.add(new CommonCustomer(id, name,cart));
            }
            return result;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


        @Override
    public Customer getById(int id) {
            try (Connection connection = getConnection()) {
                String query = String.format("SELECT * FROM customer as c left join customer_product as cp on c.id = cp.customer_id left join product as p on cp.product_id = p.id where c.id = %d;", id);
                ResultSet resultSet = connection.createStatement().executeQuery(query);
                resultSet.next();
                int customerId = resultSet.getInt(1);
                String name = resultSet.getString(2);
                int productId = resultSet.getInt(5);
                String productName = resultSet.getString(7);
                double productPrice = resultSet.getDouble(8);
                CommonCart cart = new CommonCart();
                cart.addProduct(new CommonProduct(productId, productName,productPrice));
                CommonCustomer commonCustomer = new CommonCustomer(customerId, name,cart);

                return commonCustomer;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

    @Override
    public void add(String name) {
        try (Connection connection = getConnection()) {
            String query = String.format("INSERT INTO `customer` (`name`) VALUES ('%s');", name);
            connection.createStatement().execute(query);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void delete(int id) {
        try (Connection connection = getConnection()) {
            String query = String.format("DELETE FROM `customer` WHERE (`id` = '%d');", id);
            connection.createStatement().execute(query);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void addToCartById(int customerId, int productId) {
        try (Connection connection = getConnection()) {
            String query = String.format("INSERT INTO `customer_product` (`customer_id`, `product_id`) VALUES ('%d', '%d');", customerId, productId);
            connection.createStatement().execute(query);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void deleteFromCart(int customerId, int productId) {
        try (Connection connection = getConnection()) {
            String query = String.format("DELETE FROM `customer_product` WHERE (`customer_id` = '%d' and `product_id` = '%d');", customerId, productId);
            connection.createStatement().execute(query);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void clearCart(int customerId) {
        try (Connection connection = getConnection()) {
            String query = String.format("DELETE FROM `customer_product` WHERE (`customer_id` = '%d');", customerId);
           connection.createStatement().execute(query);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}



