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
public class Cart extends BaseEntity{
    @OneToOne
    @JoinColumn(name="cart_user_id", nullable=false)
    private User user;

    @OneToOne
    @JoinColumn(name="cart_product_id", nullable=false)
    private Product product;

    @Column(name = "weight")
    private int productWeight;
}
