package com.example.restea.service;

import com.example.restea.model.ProductOrigin;
import com.example.restea.model.ProductType;

public interface ProductOriginService {
    ProductOrigin findOriginById(Long id);

    ProductOrigin findOriginByName(String name);
}
