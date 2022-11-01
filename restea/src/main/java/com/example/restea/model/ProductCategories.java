package com.example.restea.model;

import com.example.restea.dto.ProductFlavorDto;
import com.example.restea.dto.ProductTypeDto;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class ProductCategories {
    public ProductCategories(Set<ProductTypeDto> typeCategory, Set<ProductFlavorDto> flavorCategory) {
        this.typeCategory = typeCategory;
        this.flavorCategory = flavorCategory;
    }

    private Set<ProductTypeDto> typeCategory;
    private Set<ProductFlavorDto> flavorCategory;
}
