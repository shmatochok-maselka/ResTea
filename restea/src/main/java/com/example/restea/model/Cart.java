package com.example.restea.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "cart")
@Getter
@Setter
@ToString
public class Cart {

    @EmbeddedId
    private CartId id;
    @OneToOne
    @JoinColumn(name="cart_user_id")
    private User user;

    @OneToOne
    @JoinColumn(name="cart_product_id")
    private Product cartProduct;

    @Column(name = "weight")
    private int productWeight;
}
