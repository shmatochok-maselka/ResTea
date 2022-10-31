package com.example.restea.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "origin")
@Getter
@Setter
@ToString
public class ProductOrigin extends BaseEntity{
    @Column(name = "name")
    private String name;

    //@JsonIgnore
//    @ManyToOne(mappedBy = "origin")
//    @OneToOne(mappedBy = "origin")
 //   @JsonIgnore
    @OneToMany(mappedBy="origin")
    private List<Product> products;
}
