package com.example.restea.dto;

import com.example.restea.model.*;

import com.example.restea.service.ProductFlavorService;
import com.example.restea.service.ProductPropertyService;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class ProductDto {
    private Long id;
    private String name;
    private String description;
    private String image;
    private int price;
    private ProductType type;
    private ProductOrigin origin;
    private Set<ProductFlavor> flavors;
    private Set<ProductProperty> properties;

    public ProductDto(Product product){
        this.id = product.getId();
        this.name = product.getName();
        this.description = product.getDescription();
        this.image = product.getImage();
        this.price = product.getPrice();
        this.origin = product.getOrigin();
        this.type = product.getType();
        this.flavors = product.getFlavors();
//                flavorsSetToFlavorsDtoSet(product);
        this.properties = product.getProperties();
//                propertySetToPropertyDtoSet(product);
    }


    public Product toProduct(){
        Product product = new Product();
        product.setName(name);
        product.setDescription(description);
        product.setImage(image);
        product.setPrice(price);
        product.setType(type);
        product.setOrigin(origin);
        return product;
    }

}
