package com.example.restea.service.impl;

import com.example.restea.dto.BlogPostDto;
import com.example.restea.dto.ProductTypeDto;
import com.example.restea.model.ProductType;
import com.example.restea.repository.ProductTypeRepository;
import com.example.restea.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ProductTypeServiceImpl implements ProductTypeService {
    private final ProductTypeRepository typeRepository;

    @Autowired
    public ProductTypeServiceImpl(ProductTypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }

    @Override
    public List<ProductTypeDto> findAllProductType() {
        return new ArrayList<>(typeRepository.findAll().stream()
                .map(ProductTypeDto::new)
                .collect(Collectors.toList()));
    }

}
