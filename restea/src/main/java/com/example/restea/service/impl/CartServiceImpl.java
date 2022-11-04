package com.example.restea.service.impl;

import com.example.restea.model.Cart;
import com.example.restea.repository.BlogPostRepository;
import com.example.restea.repository.CartRepository;
import com.example.restea.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {
    private CartRepository cartRepository;

    @Autowired
    public CartServiceImpl(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @Override
    public List<Cart> findAll() {
        return cartRepository.findAll();
    }
}
