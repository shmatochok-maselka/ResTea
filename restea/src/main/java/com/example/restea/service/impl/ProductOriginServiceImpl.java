package com.example.restea.service.impl;

import com.example.restea.dto.ProductOriginDto;
import com.example.restea.dto.ProductTypeDto;
import com.example.restea.model.ProductOrigin;
import com.example.restea.model.ProductType;
import com.example.restea.repository.ProductOriginRepository;
import com.example.restea.repository.ProductTypeRepository;
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
    public ProductOrigin findOriginById(Long id) {
        return originRepository.findById(id).get();
    }

    @Override
    public ProductOrigin findOriginByName(String name) {
        return originRepository.findByName(name);
    }

    @Override
    public Set<ProductOrigin> findAll() {
        return new HashSet<>(originRepository.findAll());
    }

    @Override
    public Set<ProductOriginDto> originSetToOriginDtoSet(Set<ProductOrigin> productOrigins) {
        Set<ProductOriginDto> originsDto = new HashSet<>();
        for (ProductOrigin productOrigin : productOrigins){
            var originDto = new ProductOriginDto();
            originDto.setId(productOrigin.getId());
            originDto.setName(productOrigin.getName());
            originsDto.add(originDto);
        }
        return originsDto;
    }
}
