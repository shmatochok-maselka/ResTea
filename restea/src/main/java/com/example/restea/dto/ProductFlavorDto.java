package com.example.restea.dto;

import com.example.restea.model.ProductFlavor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductFlavorDto {
    Long id;
    private String name;

    public ProductFlavorDto(ProductFlavor productFlavor) {
        this.id = productFlavor.getId();
        this.name = productFlavor.getName();
    }

    public ProductFlavor toProductFlavor(){
        ProductFlavor productFlavor = new ProductFlavor();
        productFlavor.setId(this.id);
        productFlavor.setName(this.name);
        return productFlavor;
    }
}
