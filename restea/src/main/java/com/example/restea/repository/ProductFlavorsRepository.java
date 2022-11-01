package com.example.restea.repository;

import com.example.restea.model.ProductFlavor;
import com.example.restea.model.ProductOrigin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductFlavorsRepository extends JpaRepository<ProductFlavor, Long> {
    ProductFlavor findByName(String name);
}
