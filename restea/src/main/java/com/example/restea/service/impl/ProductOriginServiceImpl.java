package com.example.restea.service.impl;

import com.example.restea.model.ProductOrigin;
import com.example.restea.repository.ProductOriginRepository;
import com.example.restea.repository.ProductTypeRepository;
import com.example.restea.service.ProductOriginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductOriginServiceImpl implements ProductOriginService {
    private ProductOriginRepository originRepository;

    @Autowired
    public ProductOriginServiceImpl(ProductOriginRepository originRepository) {
        this.originRepository = originRepository;
    }
    @Override
    public ProductOrigin findOriginById(Long id) {
        return originRepository.findById(id).get();
    }

    @Override
    public ProductOrigin findOriginByName(String name) {
        return originRepository.findByName(name);
    }
}
