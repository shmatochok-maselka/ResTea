package com.example.restea.service.impl;

import com.example.restea.dto.ProductFlavorDto;
import com.example.restea.dto.ProductPropertyDto;
import com.example.restea.model.ProductProperty;
import com.example.restea.repository.ProductPropertyRepository;
import com.example.restea.service.ProductPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ProductPropertyServiceImpl implements ProductPropertyService {

    private final ProductPropertyRepository propertyRepository;

    @Autowired
    public ProductPropertyServiceImpl(ProductPropertyRepository propertyRepository) {
        this.propertyRepository = propertyRepository;
    }

    @Override
    public List<ProductPropertyDto> findAllProductPropertiesDto() {
        return new ArrayList<>(propertyRepository.findAll().stream()
                .map(ProductPropertyDto::new)
                .collect(Collectors.toList()));
    }
}
