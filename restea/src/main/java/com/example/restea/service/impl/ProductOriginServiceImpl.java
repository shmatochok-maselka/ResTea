package com.example.restea.service.impl;

import com.example.restea.model.ProductOrigin;
import com.example.restea.repository.ProductOriginRepository;
import com.example.restea.service.ProductOriginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class ProductOriginServiceImpl implements ProductOriginService {
    private ProductOriginRepository originRepository;

    @Autowired
    public ProductOriginServiceImpl(ProductOriginRepository originRepository) {
        this.originRepository = originRepository;
    }

    @Override
    public Set<ProductOrigin> findAll() {
        return new HashSet<>(originRepository.findAll());
    }

}
