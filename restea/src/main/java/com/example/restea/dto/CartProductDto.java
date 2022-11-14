package com.example.restea.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CartProductDto {
    private ProductDto product;
    private int productWeight;

    public CartProductDto(ProductDto product, int productWeight) {
        this.product = product;
        this.productWeight = productWeight;
    }
}
