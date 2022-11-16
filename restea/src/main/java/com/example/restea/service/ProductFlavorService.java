package com.example.restea.service;

import com.example.restea.dto.ProductFlavorDto;

import java.util.List;

public interface ProductFlavorService {
    List<ProductFlavorDto> findAllProductFlavorsDto();
}
