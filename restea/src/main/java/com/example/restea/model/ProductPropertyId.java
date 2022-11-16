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
public class ProductPropertyId implements Serializable {
    @Column(name = "product_id")
    private long productId;

    @Column(name = "property_id")
    private long propertyId;

    public ProductPropertyId(long productId, long propertyId) {
        this.productId = productId;
        this.propertyId = propertyId;
    }
}
