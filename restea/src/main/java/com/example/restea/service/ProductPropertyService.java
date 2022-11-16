package com.example.restea.service;

import com.example.restea.dto.ProductPropertyDto;

import java.util.List;

public interface ProductPropertyService {
    List<ProductPropertyDto> findAllProductPropertiesDto();
}
