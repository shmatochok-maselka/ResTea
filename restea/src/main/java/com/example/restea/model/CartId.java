package com.example.restea.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class CartId implements Serializable {
    @Column(name = "cart_user_id")
    private long userId;

    @Column(name = "cart_product_id")
    private long productId;
}
