package com.example.restea.service;

import com.example.restea.dto.ProductTypeDto;
import com.example.restea.model.Product;
import com.example.restea.model.ProductType;
import com.example.restea.model.User;

import java.util.List;
import java.util.Set;

public interface ProductTypeService {

    ProductType findTypeById(Long id);

    ProductType findTypeByName(String name);

    Set<ProductType> findAll();

    Set<ProductTypeDto> typeSetToTypeDtoSet(Set<ProductType> productTypes);
}
