package com.example.restea.service;

import com.example.restea.dto.ProductFlavorDto;
import com.example.restea.model.ProductFlavor;
import com.example.restea.model.ProductOrigin;
import com.example.restea.model.ProductType;

import java.util.Set;

public interface ProductFlavorService {
    ProductFlavor findFlavorById(Long id);

    ProductFlavor findFlavorByName(String name);
    Set<ProductFlavor> findAll();

    Set<ProductFlavorDto> flavorSetToFlavorDtoSet(Set<ProductFlavor> productFlavors);
}
