package com.example.restea.dto;

import com.example.restea.model.ProductType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductTypeDto {
    private Long id;
    private String name;

    public ProductTypeDto(ProductType productType) {
        this.id = productType.getId();
        this.name = productType.getName();
    }

    public ProductType toProductType(){
        ProductType productType = new ProductType();
        productType.setId(this.id);
        productType.setName(this.name);
        return productType;
    }
}
