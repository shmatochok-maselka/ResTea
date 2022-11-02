package com.example.restea.model;

import com.example.restea.dto.ProductFlavorDto;
import com.example.restea.dto.ProductOriginDto;
import com.example.restea.dto.ProductTypeDto;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class ProductCategories {
    private Set<ProductTypeDto> typeCategory;
    private Set<ProductFlavorDto> flavorCategory;
    private Set<ProductOriginDto> originCategory;
    public ProductCategories(Set<ProductTypeDto> typeCategory, Set<ProductFlavorDto> flavorCategory,
                             Set<ProductOriginDto> originCategory) {
        this.typeCategory = typeCategory;
        this.flavorCategory = flavorCategory;
        this.originCategory = originCategory;
    }
}
