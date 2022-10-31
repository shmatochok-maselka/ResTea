package com.example.restea.repository;

import com.example.restea.model.ProductType;
import com.example.restea.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductTypeRepository extends JpaRepository<ProductType, Long> {
    ProductType findByName(String name);
}
