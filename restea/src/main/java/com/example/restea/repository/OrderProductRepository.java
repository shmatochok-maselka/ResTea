package com.example.restea.repository;

import com.example.restea.model.OrderProduct;
import com.example.restea.model.OrderProductId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderProductRepository extends JpaRepository<OrderProduct, OrderProductId> {
}
