package com.example.restea.service;

import com.example.restea.dto.ProductFlavorDto;
import com.example.restea.dto.ProductPropertyDto;
import com.example.restea.model.ProductFlavor;
import com.example.restea.model.ProductProperty;

import java.util.Set;

public interface ProductPropertyService {
    ProductProperty findPropertyById(Long id);

    ProductProperty findPropertyByName(String name);
    Set<ProductProperty> findAll();

    Set<ProductPropertyDto> propertySetToPropertyDtoSet(Set<ProductProperty> productProperties);
}
