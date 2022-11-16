package com.example.restea.dto;

import com.example.restea.model.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    private List<FlavorDto> flavors = new ArrayList<>();

    private List<PropertyDto> properties = new ArrayList<>();

    public ProductDto(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.description = product.getDescription();
        this.image = product.getImage();
        this.price = product.getPrice();
        this.origin = new ProductOriginDto(product.getOrigin());
        this.type = new ProductTypeDto(product.getType());
        this.flavors = product.getFlavors().stream()
                .map(FlavorDto::new)
                .collect(Collectors.toList());
        this.properties = product.getProperties().stream()
                .map(PropertyDto::new)
                .collect(Collectors.toList());
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
//        product.setFlavors(this.getFlavors());
//        product.setProperties(this.getProperties());
        return product;
    }
}
