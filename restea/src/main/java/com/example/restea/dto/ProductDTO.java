package com.example.restea.dto;

import com.example.restea.model.Product;
import com.example.restea.model.ProductType;
import com.example.restea.repository.ProductTypeRepository;
import com.example.restea.service.UserService;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

@Getter
@Setter
@NoArgsConstructor
public class ProductDto {

    @Autowired
    private ProductTypeRepository typeRepository;
    private Long id;
    private String name;

    private String description;

    private byte[] image;

    private int price;
    private String typeName;

    public ProductDto(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.description = product.getDescription();
        this.image = product.getImage();
        this.price = product.getPrice();
        this.typeName = product.getType().getName();
    }

    public Product toProduct(){
        Product product = new Product();
        product.setName(name);
        product.setDescription(description);
        product.setImage(image);
        product.setPrice(price);
        product.setType(typeRepository.findByName(typeName));
        return product;
    }
}
