package com.example.restea.service;

import com.example.restea.dto.CartProductDto;
import com.example.restea.model.Cart;
import com.example.restea.model.CartId;
import org.springframework.http.ResponseEntity;

import java.security.Principal;
import java.util.List;
import java.util.Map;

public interface CartService {
    List<Cart> findAll();
    List<Cart> findByUserId(Long userId);

    void deleteById(CartId cartId);
    Cart findById(CartId cartId);
    List<CartProductDto> getCartProductsByUserId(Long userId);
    ResponseEntity<Object> addProductToCart(Map<String, Long> productCartJSON, Principal principal);
}
