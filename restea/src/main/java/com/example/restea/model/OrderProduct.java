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

    @ManyToOne
    @JoinColumn(name="order_id", nullable=false, insertable = false, updatable = false)
    private Order order;

    @Column(name = "weight")
    private int weight;
}
