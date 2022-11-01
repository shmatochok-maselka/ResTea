package com.example.restea.service.impl;

import com.example.restea.dto.ProductTypeDto;
import com.example.restea.model.Product;
import com.example.restea.model.ProductType;
import com.example.restea.model.User;
import com.example.restea.repository.ProductRepository;
import com.example.restea.repository.ProductTypeRepository;
import com.example.restea.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @Override
    public ProductType findTypeByName(String name) {
        return typeRepository.findByName(name);
    }

    @Override
    public Set<ProductType> findAll() {
        return new HashSet<>(typeRepository.findAll());
    }

    @Override
    public Set<ProductTypeDto> typeSetToTypeDtoSet(Set<ProductType> productTypes) {
        Set<ProductTypeDto> typesDto = new HashSet<>();
        for (ProductType productType : productTypes){
            var flavorDto = new ProductTypeDto();
            flavorDto.setId(productType.getId());
            flavorDto.setName(productType.getName());
            typesDto.add(flavorDto);
        }
        return typesDto;
    }
}
