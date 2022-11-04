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
public class Cart implements Serializable {
    @Id
    @OneToOne
    @JoinColumn(name="cart_user_id", nullable=false)
    private User user;

    //@Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @OneToOne
    @JoinColumn(name="cart_product_id", nullable=false)
//    @Column(name = "cart_product_id")
    private Product product;

    @Column(name = "weight")
    private int productWeight;
}
