package com.example.restea.model;

import com.example.restea.dto.ProductFlavorDto;
import com.example.restea.dto.ProductPropertyDto;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class ProductCategories {
    private Set<ProductType> typeCategory;
    private Set<ProductFlavorDto> flavorCategory;
    private Set<ProductOrigin> originCategory;
    private Set<ProductPropertyDto> propertyCategory;
    public ProductCategories(Set<ProductType> typeCategory, Set<ProductFlavorDto> flavorCategory,
                             Set<ProductOrigin> originCategory, Set<ProductPropertyDto> propertyCategory) {
        this.typeCategory = typeCategory;
        this.flavorCategory = flavorCategory;
        this.originCategory = originCategory;
        this.propertyCategory = propertyCategory;
    }
}
