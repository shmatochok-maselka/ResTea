package com.example.restea.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class ProductCategories {
    private Set<ProductType> typeCategory;
    private Set<ProductFlavor> flavorCategory;
    private Set<ProductOrigin> originCategory;
    private Set<ProductProperty> propertyCategory;
    public ProductCategories(Set<ProductType> typeCategory, Set<ProductFlavor> flavorCategory,
                             Set<ProductOrigin> originCategory, Set<ProductProperty> propertyCategory) {
        this.typeCategory = typeCategory;
        this.flavorCategory = flavorCategory;
        this.originCategory = originCategory;
        this.propertyCategory = propertyCategory;
    }
}
