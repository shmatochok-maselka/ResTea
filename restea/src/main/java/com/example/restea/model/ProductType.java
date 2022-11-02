package com.example.restea.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
