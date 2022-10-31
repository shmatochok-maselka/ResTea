package com.example.restea.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "origin")
@Getter
@Setter
@ToString
public class ProductOrigin extends BaseEntity{
    @Column(name = "name")
    private String name;
}
