package com.example.restea.dto;

import com.example.restea.model.Product;
import com.example.restea.repository.ProductOriginRepository;
import com.example.restea.repository.ProductTypeRepository;
import com.example.restea.service.ProductOriginService;
import com.example.restea.service.ProductTypeService;
import com.example.restea.service.impl.ProductOriginServiceImpl;
import com.example.restea.service.impl.ProductTypeServiceImpl;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
public class ProductDto {

    private Long id;
    private String name;

    private String description;

    private byte[] image;

    private int price;
    private String typeName;

    private String originName;

    public ProductDto(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.description = product.getDescription();
        this.image = product.getImage();
        this.price = product.getPrice();
        this.originName = product.getOrigin().getName();
      //  this.typeName = product.getType().getName();
    }

    @Autowired
    public Product toProduct(ProductOriginServiceImpl originService, ProductTypeServiceImpl typeService){
        Product product = new Product();
        product.setName(name);
        product.setDescription(description);
        product.setImage(image);
        product.setPrice(price);
        //product.setType(typeRepository.findByName(typeName));
        product.setOrigin(originService.findOriginByName(originName));
        return product;
    }
}
