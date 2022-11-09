package com.example.restea.service.impl;

import com.example.restea.model.OrderProduct;
import com.example.restea.repository.OrderProductRepository;
import com.example.restea.service.OrderProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class OrderProductServiceImpl implements OrderProductService {
    private OrderProductRepository orderProductRepository;

    @Autowired
    public OrderProductServiceImpl(OrderProductRepository orderProductRepository) {
        this.orderProductRepository = orderProductRepository;
    }

    @Override
    public void addProductToOrder(OrderProduct orderProduct) {
        orderProductRepository.save(orderProduct);
    }
}
