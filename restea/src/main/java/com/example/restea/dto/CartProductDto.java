package com.example.restea.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
@NoArgsConstructor
public class CartProductDto {
    private Long productId;
    private String productName;
    private String productImage;
    private int productPrice;
    private int productWeight;
}
