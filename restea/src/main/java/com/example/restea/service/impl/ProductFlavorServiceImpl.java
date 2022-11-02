package com.example.restea.service.impl;

import com.example.restea.dto.ProductFlavorDto;
import com.example.restea.model.ProductFlavor;
import com.example.restea.model.ProductOrigin;
import com.example.restea.repository.ProductFlavorsRepository;
import com.example.restea.service.ProductFlavorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

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

    @Override
    public Set<ProductFlavor> findAll() {
        return new HashSet<>(flavorsRepository.findAll());
    }

    @Override
    public Set<ProductFlavorDto> flavorSetToFlavorDtoSet(Set<ProductFlavor> productFlavors) {
        Set<ProductFlavorDto> flavorsDto = new HashSet<ProductFlavorDto>();
        for (ProductFlavor productFlavor : productFlavors){
            var flavorDto = new ProductFlavorDto();
            flavorDto.setId(productFlavor.getId());
            flavorDto.setName(productFlavor.getName());
            flavorsDto.add(flavorDto);
        }
        return flavorsDto;
    }

    @Override
    public Set<ProductFlavor> flavorsDtoSetToFlavorSet(Set<ProductFlavorDto> flavorsDto){
        Set<ProductFlavor> flavors = new HashSet<ProductFlavor>();
        for (ProductFlavorDto productFlavorDto : flavorsDto){
            var flavor = new ProductFlavor();
            flavor.setId(productFlavorDto.getId());
            flavor.setName(productFlavorDto.getName());
            flavors.add(flavor);
        }
        return flavors;
    }
}
