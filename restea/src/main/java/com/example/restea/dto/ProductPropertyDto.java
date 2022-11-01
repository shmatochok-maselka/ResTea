package com.example.restea.dto;

import com.example.restea.model.ProductFlavor;
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

    public ProductPropertyDto(ProductProperty property) {
        this.id = property.getId();
        this.name = property.getName();
    }

    public ProductProperty toProperty(){
        ProductProperty property = new ProductProperty();
        property.setName(name);
        return property;
    }
}
