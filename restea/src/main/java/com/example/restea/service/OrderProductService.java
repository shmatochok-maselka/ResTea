package com.example.restea.service;

import com.example.restea.model.OrderProduct;

import java.util.List;

public interface OrderProductService {
    void addProductToOrder(OrderProduct orderProduct);

    void addAllProductsToOrder(List<OrderProduct> orderProducts);

}
