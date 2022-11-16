package com.example.restea.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "order_product")
@Getter
@Setter
@ToString
public class OrderProduct implements java.io.Serializable {
    @EmbeddedId
    private OrderProductId id;

    @Column(name = "weight")
    private int weight;
}
