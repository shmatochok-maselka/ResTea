package com.example.restea.service.impl;

import com.example.restea.model.Order;
import com.example.restea.repository.CartRepository;
import com.example.restea.repository.OrderRepository;
import com.example.restea.repository.ProductFlavorsRepository;
import com.example.restea.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
    private OrderRepository orderRepository;
    private CartRepository cartRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, CartRepository cartRepository) {
        this.orderRepository = orderRepository;
        this.cartRepository = cartRepository;
    }

    @Override
    public Order addOrder(Order order, Long userId) {
        cartRepository.deleteAllByUserId(userId);
        return orderRepository.save(order);
    }

    @Override
    public Order findByUserIdAndOrderData(Long userId, LocalDateTime orderData) {
        return orderRepository.findByUserIdAndOrderData(userId, orderData).get(1);
    }
}
