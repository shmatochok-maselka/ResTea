package com.example.restea.dto;

import com.example.restea.model.Product;
import com.example.restea.model.ProductType;
import com.example.restea.repository.ProductOriginRepository;
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
        this.typeName = product.getType().getName();
        //this.originName = product.getOrigin().getName();
    }

    @Autowired
    public Product toProduct(ProductOriginRepository originRepository, ProductTypeRepository typeRepository){
        Product product = new Product();
        product.setName(name);
        product.setDescription(description);
        product.setImage(image);
        product.setPrice(price);
        product.setType(typeRepository.findByName(typeName));
        product.setOrigin(originRepository.findByName(originName));
        return product;
    }
}
