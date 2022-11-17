package com.example.restea.repository;

import com.example.restea.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findAllByUserIdOrderByOrderDataDesc(Long userId);
}
