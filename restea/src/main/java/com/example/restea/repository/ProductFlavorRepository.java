package com.example.restea.repository;

import com.example.restea.model.ProductFlavor;
import com.example.restea.model.ProductFlavorId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductFlavorRepository extends JpaRepository<ProductFlavor, ProductFlavorId> {
}
