package com.example.restea.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "flavor")
@Getter
@Setter
@ToString
public class Flavor extends BaseEntity{
}
