package com.example.restea.dto;

import com.example.restea.model.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CartProductDto {
    private Product product;
    private int productWeight;

    public CartProductDto(Product product, int productWeight) {
        this.product = product;
        this.productWeight = productWeight;
    }
}
