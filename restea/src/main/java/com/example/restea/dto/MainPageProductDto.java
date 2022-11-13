package com.example.restea.dto;

import com.example.restea.model.Cart;
import com.example.restea.model.Product;
import com.example.restea.service.ProductService;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MainPageProductDto {
    private Long productId;
    private String productName;
    private String productImage;
    private int productPrice;

    public MainPageProductDto(Product product) {
        this.productId = product.getId();
        this.productName = product.getName();
        this.productImage = product.getImage();
        this.productPrice = product.getPrice();
    }
}
