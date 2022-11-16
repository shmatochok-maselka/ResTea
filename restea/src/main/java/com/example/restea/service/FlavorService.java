package com.example.restea.service;

import com.example.restea.dto.FlavorDto;

import java.util.List;

public interface FlavorService {
    List<FlavorDto> findAllProductFlavorsDto();
}
