package com.example.restea.service;

import com.example.restea.dto.ProductOriginDto;

import java.util.List;

public interface OriginService {
    List<ProductOriginDto> findAllProductOrigin();
}
