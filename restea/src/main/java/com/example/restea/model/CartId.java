package com.example.restea.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Setter
@Getter
@NoArgsConstructor
public class CartId implements Serializable {
    @Column(name = "cart_user_id")
    private long userId;

    @Column(name = "cart_product_id")
    private long productId;

    public CartId(long userId, long productId) {
        this.userId = userId;
        this.productId = productId;
    }
}
