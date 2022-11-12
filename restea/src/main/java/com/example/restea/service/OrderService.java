package com.example.restea.service;

import com.example.restea.model.Cart;
import com.example.restea.model.Order;

import java.time.LocalDateTime;

public interface OrderService {
    Order addOrder(Order order);

    Order findByUserIdAndOrderData(Long userId, LocalDateTime orderData);
}
