package com.example.restea.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Setter
@Getter
@NoArgsConstructor
public class OrderProductId implements Serializable {

    @Column(name = "order_id")
    private long orderId;

    @Column(name = "product_id")
    private long productId;

    public OrderProductId(long orderId, long productId) {
        this.orderId = orderId;
        this.productId = productId;
    }
}
