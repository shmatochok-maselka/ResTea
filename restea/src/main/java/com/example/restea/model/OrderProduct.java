package com.example.restea.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "order_product")
@Getter
@Setter
@ToString
public class OrderProduct implements  java.io.Serializable{
    @EmbeddedId
    private OrderProductId id;

    @Column(name = "weight")
    private int weight;
}
