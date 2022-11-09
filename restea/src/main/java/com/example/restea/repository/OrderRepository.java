package com.example.restea.repository;

import com.example.restea.model.Order;
import com.example.restea.model.OrderProduct;
import com.example.restea.model.OrderProductId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
