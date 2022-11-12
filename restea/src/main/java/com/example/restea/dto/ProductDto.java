package com.example.restea.dto;

import com.example.restea.model.ProductFlavor;
import com.example.restea.model.Product;
import com.example.restea.model.ProductProperty;
import com.example.restea.service.ProductFlavorService;
import com.example.restea.service.ProductPropertyService;
import com.example.restea.service.impl.ProductFlavorServiceImpl;
import com.example.restea.service.impl.ProductPropertyServiceImpl;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

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

    private ProductTypeDto type;

    private ProductOriginDto origin;
    private Set<ProductFlavorDto> flavors;
    private Set<ProductPropertyDto> properties;

    public ProductDto(Product product){
        this.id = product.getId();
        this.name = product.getName();
        this.description = product.getDescription();
        this.image = product.getImage();
        this.price = product.getPrice();
        this.origin = new ProductOriginDto(product.getOrigin());
        this.type = new ProductTypeDto(product.getType());
        this.flavors = flavorsSetToFlavorsDtoSet(product);
        this.properties = propertySetToPropertyDtoSet(product);
    }

    public Product toProduct(ProductFlavorService flavorService,
                             ProductPropertyService propertyService){
        Product product = new Product();
        product.setName(name);
        product.setDescription(description);
        product.setImage(image);
        product.setPrice(price);
        product.setType(type.toType());
        product.setOrigin(origin.toOrigin());
        product.setFlavors(flavorService.flavorsDtoSetToFlavorSet(this.getFlavors()));
        product.setProperties(propertyService.propertyDtoSetToPropertySet(this.getProperties()));
        return product;
    }

    public Set<ProductFlavorDto> flavorsSetToFlavorsDtoSet(Product product){
        Set<ProductFlavorDto> flavorsDto = new HashSet<ProductFlavorDto>();
        for (ProductFlavor productFlavor : product.getFlavors()){
            var flavorDto = new ProductFlavorDto();
            flavorDto.setId(productFlavor.getId());
            flavorDto.setName(productFlavor.getName());
            flavorsDto.add(flavorDto);
        }
        return flavorsDto;
    }

    public Set<ProductPropertyDto> propertySetToPropertyDtoSet(Product product){
        Set<ProductPropertyDto> propertiesDto = new HashSet<ProductPropertyDto>();
        for (ProductProperty productProperty : product.getProperties()){
            var propertyDto = new ProductPropertyDto();
            propertyDto.setId(productProperty.getId());
            propertyDto.setName(productProperty.getName());
            propertiesDto.add(propertyDto);
        }
        return propertiesDto;
    }

}
