package com.example.restea.service;

import com.example.restea.model.ProductOrigin;
import com.example.restea.model.ProductType;

import java.util.Set;

public interface ProductOriginService {
    ProductOrigin findOriginById(Long id);

    ProductOrigin findOriginByName(String name);

    Set<ProductOrigin> findAll();
}
