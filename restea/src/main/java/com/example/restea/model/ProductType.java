package com.example.restea.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "type")
@Getter
@Setter
@ToString
public class ProductType extends BaseEntity{
    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy="type")
    private List<Product> products;
}
