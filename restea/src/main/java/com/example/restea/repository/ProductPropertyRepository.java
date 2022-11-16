package com.example.restea.repository;

import com.example.restea.model.ProductFlavor;
import com.example.restea.model.ProductFlavorId;
import com.example.restea.model.ProductProperty;
import com.example.restea.model.ProductPropertyId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductPropertyRepository extends JpaRepository<ProductProperty, ProductPropertyId> {
}
