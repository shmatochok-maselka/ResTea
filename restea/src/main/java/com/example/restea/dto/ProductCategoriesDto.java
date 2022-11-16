package com.example.restea.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProductCategoriesDto {
    private List<ProductTypeDto> typeCategory;
    private List<FlavorDto> flavorCategory;
    private List<ProductOriginDto> originCategory;
    private List<PropertyDto> propertyCategory;
    public ProductCategoriesDto(List<ProductTypeDto> typeCategory, List<FlavorDto> flavorCategory,
                                List<ProductOriginDto> originCategory, List<PropertyDto> propertyCategory) {
        this.typeCategory = typeCategory;
        this.flavorCategory = flavorCategory;
        this.originCategory = originCategory;
        this.propertyCategory = propertyCategory;
    }
}
