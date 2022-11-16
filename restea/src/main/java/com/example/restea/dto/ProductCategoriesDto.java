package com.example.restea.dto;

import com.example.restea.model.ProductFlavor;
import com.example.restea.model.ProductOrigin;
import com.example.restea.model.ProductProperty;
import com.example.restea.model.ProductType;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class ProductCategoriesDto {
    private Set<ProductType> typeCategory;
    private Set<ProductFlavor> flavorCategory;
    private Set<ProductOrigin> originCategory;
    private Set<ProductProperty> propertyCategory;
    public ProductCategoriesDto(Set<ProductType> typeCategory, Set<ProductFlavor> flavorCategory,
                                Set<ProductOrigin> originCategory, Set<ProductProperty> propertyCategory) {
        this.typeCategory = typeCategory;
        this.flavorCategory = flavorCategory;
        this.originCategory = originCategory;
        this.propertyCategory = propertyCategory;
    }
}
