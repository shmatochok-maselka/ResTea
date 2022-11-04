package com.example.restea.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
public class CartId implements Serializable {
    @OneToOne
    @JoinColumn(name="cart_user_id")
    private User user;

    @OneToOne
    @JoinColumn(name="cart_product_id")
    private Product cartProduct;
}
