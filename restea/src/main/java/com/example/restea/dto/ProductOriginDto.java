package com.example.restea.dto;

import com.example.restea.model.ProductOrigin;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductOriginDto {
    private Long id;
    private String name;

    public ProductOriginDto(ProductOrigin productOrigin) {
        this.id = productOrigin.getId();
        this.name = productOrigin.getName();
    }

    public ProductOrigin toProductOrigin(){
        ProductOrigin productOrigin = new ProductOrigin();
        productOrigin.setId(this.id);
        productOrigin.setName(this.name);
        return productOrigin;
    }
}
