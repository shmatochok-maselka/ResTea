package com.example.restea.service.impl;

import com.example.restea.dto.ProductFlavorDto;
import com.example.restea.dto.ProductOriginDto;
import com.example.restea.model.ProductFlavor;
import com.example.restea.repository.ProductFlavorsRepository;
import com.example.restea.service.ProductFlavorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductFlavorServiceImpl implements ProductFlavorService {
    private final ProductFlavorsRepository flavorsRepository;

    @Autowired
    public ProductFlavorServiceImpl(ProductFlavorsRepository flavorsRepository) {
        this.flavorsRepository = flavorsRepository;
    }

    @Override
    public List<ProductFlavorDto> findAllProductFlavorsDto() {
        return new ArrayList<>(flavorsRepository.findAll().stream()
                .map(ProductFlavorDto::new)
                .collect(Collectors.toList()));
    }

}
