package com.example.restea.dto;

import com.example.restea.model.Product;
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

    public ProductTypeDto(ProductType type) {
        this.id = type.getId();
        this.name = type.getName();
    }

    public ProductType toType(){
        ProductType type = new ProductType();
        type.setName(name);
        return type;
    }
}
