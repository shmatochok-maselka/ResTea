package com.example.restea.dto;

import com.example.restea.model.ProductOrigin;
import com.example.restea.model.ProductType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductOriginDto {
    private Long id;
    private String name;

    public ProductOriginDto(ProductOrigin origin) {
        this.id = origin.getId();
        this.name = origin.getName();
    }

    public ProductOrigin toOrigin(){
        ProductOrigin origin = new ProductOrigin();
        origin.setName(name);
        return origin;
    }
}
