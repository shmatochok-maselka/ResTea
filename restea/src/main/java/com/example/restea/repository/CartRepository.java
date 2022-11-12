package com.example.restea.repository;

import com.example.restea.model.Cart;
import com.example.restea.model.CartId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<Cart, CartId> {
    @Query(value = "SELECT product, cart.productWeight FROM Cart cart JOIN Product product ON cart.id.productId = product.id  where cart.id.userId = ?1")
    List<Object[]> findAllCartProductsByUserId(Long userId);

//    @Query(value = "SELECT cart FROM Cart cart WHERE cart.id.userId = ?1 AND cart.id.productId = ?2")
    Optional<Cart> findById(CartId cardId);
}
