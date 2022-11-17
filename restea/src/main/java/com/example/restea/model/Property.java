package com.example.restea.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "property")
@Getter
@Setter
@ToString
public class Property extends BaseEntity {
    @Column(name = "name")
    private String name;

    @JsonIgnore
    @ManyToMany(mappedBy = "properties")
    private List<Product> products = new ArrayList<>();
}
