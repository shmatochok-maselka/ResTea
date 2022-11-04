package com.example.restea.service;

import com.example.restea.model.BlogPost;
import com.example.restea.model.Cart;

import java.util.List;

public interface CartService {
    List<Cart> findAll();
}
