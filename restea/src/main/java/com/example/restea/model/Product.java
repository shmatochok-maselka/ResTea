package com.example.restea.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

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

    @ManyToOne
    @JoinColumn(name="origin_id", nullable=false)
    private ProductOrigin origin;

    @ManyToOne
    @JoinColumn(name="type_id", nullable=false)
    private ProductType type;

    /*@ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "product_flavor",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "flavor_id")
    )@ToString.Exclude
    private Set<Flavor> flavors;*/
}
