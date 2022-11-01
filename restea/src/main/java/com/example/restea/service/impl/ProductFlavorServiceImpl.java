package com.example.restea.service.impl;

import com.example.restea.model.ProductFlavor;
import com.example.restea.model.ProductOrigin;
import com.example.restea.repository.ProductFlavorsRepository;
import com.example.restea.service.ProductFlavorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductFlavorServiceImpl implements ProductFlavorService {
    private ProductFlavorsRepository flavorsRepository;

    @Autowired
    public ProductFlavorServiceImpl(ProductFlavorsRepository flavorsRepository) {
        this.flavorsRepository = flavorsRepository;
    }
    @Override
    public ProductFlavor findFlavorById(Long id) {
        return flavorsRepository.findById(id).get();
    }

    @Override
    public ProductFlavor findFlavorByName(String name) {
        return flavorsRepository.findByName(name);
    }
}
