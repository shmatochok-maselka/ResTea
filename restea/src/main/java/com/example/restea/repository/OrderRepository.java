package com.example.restea.repository;

import com.example.restea.model.Order;
import com.example.restea.model.OrderProduct;
import com.example.restea.model.OrderProductId;
import com.example.restea.model.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
//    @Query(value = "SELECT id FROM Order_client WHERE order_data = order.getOrderData()")
    List<Order> findByUserIdAndOrderData(Long userId, LocalDateTime orderData);
}
