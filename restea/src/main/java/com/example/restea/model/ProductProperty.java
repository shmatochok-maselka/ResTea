package com.example.restea.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "properties")
@Getter
@Setter
@ToString
public class ProductProperty extends BaseEntity{
    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "flavors")
    private Set<Product> products = new HashSet<Product>();
}
