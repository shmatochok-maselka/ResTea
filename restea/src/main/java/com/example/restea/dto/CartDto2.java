package com.example.restea.dto;

import com.example.restea.model.Cart;
import com.example.restea.model.CartId;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CartDto2 {
    private Long productId;
    private Long userId;
    private int weight;

    public CartDto2(Cart cart) {
//        this.userId = cart.getId().getUserId();
//        this.userId = cart.getUser().getId();
//        this.productId = cart.getId().getProductId();
//        this.productId = cart.getCartProduct().getId();
        this.weight = cart.getProductWeight();
    }
}
