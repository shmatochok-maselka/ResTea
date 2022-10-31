package com.example.restea.service.impl;

import com.example.restea.model.Product;
import com.example.restea.model.ProductType;
import com.example.restea.repository.ProductRepository;
import com.example.restea.repository.ProductTypeRepository;
import com.example.restea.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductTypeServiceImpl implements ProductTypeService {
    private ProductTypeRepository typeRepository;

    @Autowired
    public ProductTypeServiceImpl(ProductTypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }

    @Override
    public ProductType findTypeById(Long id) {
        return typeRepository.findById(id).get();
    }
}
