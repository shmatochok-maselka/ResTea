package com.example.restea.service;

import com.example.restea.dto.OrderDto;
import com.example.restea.model.Cart;
import com.example.restea.model.Order;

import java.time.LocalDateTime;

public interface OrderService {
    Order addOrder(Order order, Long userId, CartService cartService);
//
    Order findByUserIdAndOrderData(Long userId, LocalDateTime orderData);
}
