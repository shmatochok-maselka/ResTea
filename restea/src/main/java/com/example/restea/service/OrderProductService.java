package com.example.restea.service;

import com.example.restea.model.Order;
import com.example.restea.model.OrderProduct;

public interface OrderProductService {
    void addProductToOrder(OrderProduct orderProduct);
}
