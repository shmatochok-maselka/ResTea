package com.example.restea.service;

import com.example.restea.dto.ProductTypeDto;

import java.util.List;

public interface TypeService {
    List<ProductTypeDto> findAllProductType();
}
