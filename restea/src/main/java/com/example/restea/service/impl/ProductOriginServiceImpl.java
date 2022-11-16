package com.example.restea.service.impl;

import com.example.restea.dto.ProductOriginDto;
import com.example.restea.dto.ProductTypeDto;
import com.example.restea.model.ProductOrigin;
import com.example.restea.repository.ProductOriginRepository;
import com.example.restea.service.ProductOriginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ProductOriginServiceImpl implements ProductOriginService {
    private final ProductOriginRepository originRepository;

    @Autowired
    public ProductOriginServiceImpl(ProductOriginRepository originRepository) {
        this.originRepository = originRepository;
    }

    @Override
    public List<ProductOriginDto> findAllProductOrigin() {
        return new ArrayList<>(originRepository.findAll().stream()
                .map(ProductOriginDto::new)
                .collect(Collectors.toList()));
    }

}
