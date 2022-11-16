package com.example.restea.dto;

import com.example.restea.model.ProductProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductPropertyDto {
    private Long id;
    private String name;

    public ProductPropertyDto(ProductProperty productProperty) {
        this.id = productProperty.getId();
        this.name = productProperty.getName();
    }

    public ProductProperty toProductProperty(){
        ProductProperty productProperty = new ProductProperty();
        productProperty.setId(this.id);
        productProperty.setName(this.name);
        return productProperty;
    }
}
