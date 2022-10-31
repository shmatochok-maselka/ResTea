package com.example.restea.dto;

import com.example.restea.model.Product;
import com.example.restea.model.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class ProductDTO {
    private Long id;
    private String name;

    private String description;

   // private byte[] image;

    private int price;


    public ProductDTO(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.description = product.getDescription();
       // this.image = product.getImage();
        this.price = product.getPrice();
    }

    public Product toProduct(){
        Product product = new Product();
        product.setName(name);
        product.setDescription(description);
      //  product.setImage(image);
        product.setPrice(price);
        return product;
    }
}
