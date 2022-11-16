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
public class ProductFlavorId implements Serializable {
    @Column(name = "product_id")
    private long productId;

    @Column(name = "flavor_id")
    private long flavorId;

    public ProductFlavorId(long productId, long flavorId) {
        this.productId = productId;
        this.flavorId = flavorId;
    }
}
