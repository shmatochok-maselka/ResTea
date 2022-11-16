package com.example.restea.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Type extends BaseEntity{
    @Column(name = "name")
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy="type")
    private List<Product> products;
}
