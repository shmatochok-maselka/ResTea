package com.example.restea.service;

import com.example.restea.dto.CartAddDto;
import com.example.restea.dto.CartProductDto;
import com.example.restea.model.Cart;
import com.example.restea.model.CartId;

import java.security.Principal;
import java.util.List;

public interface CartService {
    List<Cart> findAll();

    void deleteById(CartId cartId);

    Cart findById(CartId cartId);

    List<CartProductDto> getCartProductsByUserId(Long userId);

    void addProductToCart(CartAddDto cartAddDto, Principal principal);

    void updateProductCart(Long userId, CartAddDto cartAddDto);
}
