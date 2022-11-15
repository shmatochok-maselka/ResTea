package com.example.restea.dto;

import com.example.restea.model.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class ProductDto {

    Long id;
    private String name;

    private String description;

    private String image;

    private int price;

    private ProductOrigin origin;

    private ProductType type;

    private Set<ProductFlavor> flavors = new HashSet<>();

    private Set<ProductProperty> properties = new HashSet<>();

    public ProductDto(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.description = product.getDescription();
        this.image = product.getImage();
        this.price = product.getPrice();
        this.origin = product.getOrigin();
        this.type = product.getType();
        this.flavors = product.getFlavors();
        this.properties = product.getProperties();
    }
}
