package com.example.restea.repository;

import com.example.restea.model.OrderProduct;
import com.example.restea.model.OrderProductId;
import com.example.restea.model.ProductFlavor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderProductRepository extends JpaRepository<OrderProduct, OrderProductId> {
}
