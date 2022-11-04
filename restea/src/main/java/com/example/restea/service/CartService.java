package com.example.restea.service;

import com.example.restea.dto.CartProductDto;
import com.example.restea.model.BlogPost;
import com.example.restea.model.Cart;
import com.example.restea.model.Product;
import com.example.restea.model.User;

import java.util.List;
import java.util.Map;

public interface CartService {
    List<Cart> findAll();
    public Map<User, List<CartProductDto>> groupCartProductsByUserId();
}
