package com.example.restea.dto;

import com.example.restea.model.ProductFlavor;
import com.example.restea.model.ProductOrigin;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductFlavorDto {
    private Long id;
    private String name;

    public ProductFlavorDto(ProductFlavor flavor) {
        this.id = flavor.getId();
        this.name = flavor.getName();
    }

    public ProductFlavor toFlavor(){
        ProductFlavor flavor = new ProductFlavor();
        flavor.setName(name);
        return flavor;
    }
}
