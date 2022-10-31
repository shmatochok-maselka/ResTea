package com.example.restea.repository;

import com.example.restea.model.ProductOrigin;
import com.example.restea.model.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductOriginRepository extends JpaRepository<ProductOrigin, Long> {
    ProductOrigin findByName(String name);
}
