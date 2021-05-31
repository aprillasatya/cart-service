package com.trunk.cartservice.repository;

import com.trunk.cartservice.dto.CartMapping;
import com.trunk.cartservice.model.CartModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<CartModel, Integer> {
    @Query(value = "SELECT p.product_name as productName, p.product_price as productPrice, p.product_description as productDesc, " +
            "p.product_status as productStatus, u.user_name as userName " +
            "FROM carts c " +
            "INNER JOIN products p on c.product_id = p.id " +
            "INNER JOIN users u on c.user_id = u.id " +
            "where c.user_id = ?1", nativeQuery = true)
    List<CartMapping> getCartByUserId(int userId);
}
