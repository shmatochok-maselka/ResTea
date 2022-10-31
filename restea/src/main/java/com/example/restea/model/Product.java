package com.example.restea.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "product")
@Getter
@Setter
@ToString
public class Product extends BaseEntity{
    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "image")
    private byte[] image;

    @Column(name = "price")
    private int price;

    /*@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "type_id")
    private ProductType type;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "origin_id")
    private ProductOrigin origin;*/
}
