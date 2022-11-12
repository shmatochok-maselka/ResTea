package com.example.restea.service;

import com.example.restea.dto.CartProductDto;
import com.example.restea.model.Cart;
import com.example.restea.model.CartId;

import java.util.List;

public interface CartService {
    List<Cart> findAll();
    List<Cart> findByUserId(Long userId);

    void deleteById(CartId cartId);
    Cart findById(CartId cartId);
    List<CartProductDto> getCartProductsByUserId(Long userId);
    void addProductToCart(Cart cart);
}
