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
public class Cart implements  java.io.Serializable{

    @EmbeddedId
    private CartId id;

    @Transient
    public User getUser() {
        return this.id.getUser();
    }

    @Transient
    public void setUser(User user) {
        this.id.setUser(user);
    }

    @Transient
    public Product getCartProduct() {
        return this.id.getCartProduct();
    }

    @Transient
    public void setCartProduct(Product product) {
        this.id.setCartProduct(product);
    }

    @Column(name = "weight")
    private int productWeight;
}
