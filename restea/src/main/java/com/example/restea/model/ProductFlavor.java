package com.example.restea.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "product_flavor")
@DynamicUpdate
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ProductFlavor implements java.io.Serializable {
    @EmbeddedId
    private ProductFlavorId id;
}
