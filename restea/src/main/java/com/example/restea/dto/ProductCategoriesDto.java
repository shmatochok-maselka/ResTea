package com.example.restea.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProductCategoriesDto {
    private List<TypeDto> typeCategory;
    private List<FlavorDto> flavorCategory;
    private List<OriginDto> originCategory;
    private List<PropertyDto> propertyCategory;
    public ProductCategoriesDto(List<TypeDto> typeCategory, List<FlavorDto> flavorCategory,
                                List<OriginDto> originCategory, List<PropertyDto> propertyCategory) {
        this.typeCategory = typeCategory;
        this.flavorCategory = flavorCategory;
        this.originCategory = originCategory;
        this.propertyCategory = propertyCategory;
    }
}
