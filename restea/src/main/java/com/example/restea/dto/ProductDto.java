package com.example.restea.dto;

import com.example.restea.model.Product;
import com.example.restea.model.ProductFlavor;
import com.example.restea.model.ProductProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    private ProductOriginDto origin;

    private ProductTypeDto type;

    private Set<ProductFlavor> flavors = new HashSet<>();

    private Set<ProductProperty> properties = new HashSet<>();

    public ProductDto(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.description = product.getDescription();
        this.image = product.getImage();
        this.price = product.getPrice();
        this.origin = new ProductOriginDto(product.getOrigin());
        this.type = new ProductTypeDto(product.getType());
        this.flavors = product.getFlavors();
        this.properties = product.getProperties();
    }

    public Product toProduct(){
        Product product = new Product();
        product.setId(this.id);
        product.setName(this.name);
        product.setDescription(this.description);
        product.setImage(this.image);
        product.setPrice(this.price);
        product.setOrigin(this.origin.toProductOrigin());
        product.setType(this.type.toProductType());
        product.setFlavors(this.getFlavors());
        product.setProperties(this.getProperties());
        return product;
    }
}
