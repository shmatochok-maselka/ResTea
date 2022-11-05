package com.example.restea.dto;

import com.example.restea.model.Cart;
import com.example.restea.model.ProductFlavor;
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

    public CartProductDto(Cart cart) {
//        this.productId = cart.getCartProduct().getId();
//        this.productName = cart.getCartProduct().getName();
//        this.productImage = cart.getCartProduct().getImage();
//        this.productPrice = cart.getCartProduct().getPrice();
        this.productWeight = cart.getProductWeight();
    }
}
