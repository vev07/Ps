package de.telran.lesson3.repository_layer.jpa;

import de.telran.lesson3.domain_layer.entity.jpa.JpaCustomer;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaCustomerRepository extends JpaRepository<JpaCustomer, Integer> {

    @Transactional
    void deleteByName(String name);


    @Transactional
    @Query(value = "INSERT INTO `shop_jpa`.`cart_product` (`cart_id`, `product_id`) VALUES (customerId, productId);", nativeQuery = true)
    void addToCartById(@Param("customerId") int customerId, @Param("productId")int productId);

    @Transactional
    @Query(value = "UPDATE `shop_jpa`.`cart_product` SET `id` = NULL, `cart_id` = NULL, `product_id` = NULL WHERE (`cart_id` = customerId AND `product_id` = productId;", nativeQuery = true)
    void deleteFromCart(@Param("customerId") int customerId, @Param("productId")int productId);

    @Transactional
    @Query(value = "UPDATE `shop_jpa`.`cart_product` SET `id` = NULL, `cart_id` = NULL, `product_id` = NULL WHERE (`cart_id` = customerId;", nativeQuery = true)
    public void clearCart(@Param("customerId") int customerId);

}
