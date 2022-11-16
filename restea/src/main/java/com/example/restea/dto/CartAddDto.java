package com.example.restea.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CartAddDto {
    Long productId;

    int productWeight;
}
