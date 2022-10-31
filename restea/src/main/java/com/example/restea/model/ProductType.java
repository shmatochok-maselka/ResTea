package com.example.restea.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "type")
@Getter
@Setter
@ToString
public class ProductType extends BaseEntity{
    @Column(name = "name")
    private String name;

    /*@OneToOne(mappedBy = "type")
    private Product product;*/
}
