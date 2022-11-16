package com.example.restea.service.impl;

import com.example.restea.model.ProductProperty;
import com.example.restea.repository.ProductPropertyRepository;
import com.example.restea.service.ProductPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class ProductPropertyServiceImpl implements ProductPropertyService {

    private final ProductPropertyRepository propertyRepository;

    @Autowired
    public ProductPropertyServiceImpl(ProductPropertyRepository propertyRepository) {
        this.propertyRepository = propertyRepository;
    }

    @Override
    public Set<ProductProperty> findAll() {
        return new HashSet<>(propertyRepository.findAll());
    }
}
