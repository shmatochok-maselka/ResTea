package com.example.restea.dto;

import com.example.restea.model.ProductFlavor;
import com.example.restea.model.ProductOrigin;
import com.example.restea.model.ProductProperty;
import com.example.restea.model.ProductType;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
public class ProductCategoriesDto {
    private List<ProductTypeDto> typeCategory;
    private List<ProductFlavorDto> flavorCategory;
    private List<ProductOriginDto> originCategory;
    private List<ProductPropertyDto> propertyCategory;
    public ProductCategoriesDto(List<ProductTypeDto> typeCategory, List<ProductFlavorDto> flavorCategory,
                                List<ProductOriginDto> originCategory, List<ProductPropertyDto> propertyCategory) {
        this.typeCategory = typeCategory;
        this.flavorCategory = flavorCategory;
        this.originCategory = originCategory;
        this.propertyCategory = propertyCategory;
    }
}
