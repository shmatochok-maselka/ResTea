package com.example.restea.service.impl;

import com.example.restea.dto.ProductFlavorDto;
import com.example.restea.dto.ProductPropertyDto;
import com.example.restea.model.ProductFlavor;
import com.example.restea.model.ProductProperty;
import com.example.restea.repository.ProductFlavorsRepository;
import com.example.restea.repository.ProductPropertyRepository;
import com.example.restea.service.ProductPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class ProductPropertyServiceImpl implements ProductPropertyService {

    private ProductPropertyRepository propertyRepository;

    @Autowired
    public ProductPropertyServiceImpl(ProductPropertyRepository propertyRepository) {
        this.propertyRepository = propertyRepository;
    }

    @Override
    public ProductProperty findPropertyById(Long id) {
        return propertyRepository.findById(id).get();
    }

    @Override
    public ProductProperty findPropertyByName(String name) {
        return propertyRepository.findByName(name);
    }

    @Override
    public Set<ProductProperty> findAll() {
        return new HashSet<>(propertyRepository.findAll());
    }

    @Override
    public Set<ProductPropertyDto> propertySetToPropertyDtoSet(Set<ProductProperty> productProperties) {
        Set<ProductPropertyDto> propertiesDto = new HashSet<ProductPropertyDto>();
        for (ProductProperty productProperty : productProperties){
            var propertyDto = new ProductPropertyDto();
            propertyDto.setId(productProperty.getId());
            propertyDto.setName(productProperty.getName());
            propertiesDto.add(propertyDto);
        }
        return propertiesDto;
    }
}
