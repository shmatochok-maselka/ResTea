package com.example.restea.service;

import com.example.restea.dto.OrderDto;
import com.example.restea.model.Order;

import java.util.List;

public interface OrderService {
    Order addOrder(Order order, Long userId, CartService cartService);
    List<OrderDto> findAllUserOrders(Long userId);
}
