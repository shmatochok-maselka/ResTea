package com.example.restea.service.impl;

import com.example.restea.dto.ProductTypeDto;
import com.example.restea.repository.TypeRepository;
import com.example.restea.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TypeServiceImpl implements TypeService {
    private final TypeRepository typeRepository;

    @Autowired
    public TypeServiceImpl(TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }

    @Override
    public List<ProductTypeDto> findAllProductType() {
        return new ArrayList<>(typeRepository.findAll().stream()
                .map(ProductTypeDto::new)
                .collect(Collectors.toList()));
    }

}
