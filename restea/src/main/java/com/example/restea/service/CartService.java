package com.example.restea.service;

import com.example.restea.dto.CartProductDto;
import com.example.restea.model.Cart;
import com.example.restea.model.User;

import java.util.List;
import java.util.Map;

public interface CartService {
    List<Cart> findAll();
//    private Map<Long, List<CartProductDto>> groupCartProductsByUser();

    List<Cart> findById_OrderCode(Long userId);
    List<CartProductDto> getCartProductsByUserId(Long userId, ProductService productService);
    void addProductToCart(Cart cart);
}
