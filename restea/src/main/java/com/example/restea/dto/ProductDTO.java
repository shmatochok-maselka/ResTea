package com.example.restea.dto;

import com.example.restea.model.ProductFlavor;
import com.example.restea.model.Product;
import com.example.restea.service.impl.ProductFlavorServiceImpl;
import com.example.restea.service.impl.ProductOriginServiceImpl;
import com.example.restea.service.impl.ProductTypeServiceImpl;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class ProductDto {

    private Long id;
    private String name;

    private String description;

    private byte[] image;

    private int price;
//    private String typeName;

    private ProductTypeDto type;

    private ProductOriginDto origin;

//    private String originName;

//    private Set<String> flavors;
    private Set<ProductFlavorDto> flavors;
    public ProductDto(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.description = product.getDescription();
        this.image = product.getImage();
        this.price = product.getPrice();
//        this.originName = product.getOrigin().getName();
//        this.typeName = product.getType().getName();
        this.origin = new ProductOriginDto(product.getOrigin());
        this.type = new ProductTypeDto(product.getType());
        this.flavors = flavorsDtoSet(product);
    }

    @Autowired
    public Product toProduct(ProductOriginServiceImpl originService, ProductTypeServiceImpl typeService,
                             ProductFlavorServiceImpl flavorService){
        Product product = new Product();
        product.setName(name);
        product.setDescription(description);
        product.setImage(image);
        product.setPrice(price);
        product.setType(type.toType());
        product.setOrigin(origin.toOrigin());
        product.setFlavors(flavorsSet());
        return product;
    }

    public Set<ProductFlavorDto> flavorsDtoSet(Product product){
        Set<ProductFlavorDto> flavorsDto = new HashSet<ProductFlavorDto>();
        for (ProductFlavor productFlavor : product.getFlavors()){
            var flavorDto = new ProductFlavorDto();
            flavorDto.setId(productFlavor.getId());
            flavorDto.setName(productFlavor.getName());
            flavorsDto.add(flavorDto);
        }
        return flavorsDto;
    }

    public Set<ProductFlavor> flavorsSet(){
        Set<ProductFlavor> flavors = new HashSet<ProductFlavor>();
        for (ProductFlavorDto productFlavorDto : this.getFlavors()){
            var flavor = new ProductFlavor();
            flavor.setId(productFlavorDto.getId());
            flavor.setName(productFlavorDto.getName());
            flavors.add(flavor);
        }
        return flavors;
    }
}
