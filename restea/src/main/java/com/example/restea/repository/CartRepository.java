package com.example.restea.repository;

import com.example.restea.dto.CartDto;
import com.example.restea.dto.CartProductDto;
import com.example.restea.model.Cart;
import com.example.restea.model.CartId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, CartId> {
    @Query(value = "SELECT product, cart.productWeight FROM Cart cart JOIN Product product ON cart.id.productId = product.id  where cart.id.userId = ?1")
    List<Object[]> findAllCartProductsByUserId(Long userId);
}
