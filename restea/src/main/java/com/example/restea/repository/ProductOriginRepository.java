package com.example.restea.repository;

import com.example.restea.model.Product;
import com.example.restea.model.ProductOrigin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductOriginRepository extends JpaRepository<ProductOrigin, Long> {
}
