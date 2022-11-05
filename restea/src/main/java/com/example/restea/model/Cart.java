package com.example.restea.model;

import com.example.restea.service.CartService;
import com.example.restea.service.ProductService;
import com.example.restea.service.UserService;
import com.example.restea.service.impl.ProductServiceImpl;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "cart")
@DynamicUpdate
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Cart implements  java.io.Serializable{

    @EmbeddedId
    private CartId id;

    @OneToOne()
    @JoinColumn(name="cart_user_id", insertable=false, updatable=false)
    private User user;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="cart_product_id", insertable=false, updatable=false)
    private Product cartProduct;

    @Column(name = "weight")
    private int productWeight;
}
