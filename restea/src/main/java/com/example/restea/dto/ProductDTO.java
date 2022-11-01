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
    private String typeName;

    private String originName;

    //private Set<ProductFlavor> flavors;
    public ProductDto(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.description = product.getDescription();
        this.image = product.getImage();
        this.price = product.getPrice();
        this.originName = product.getOrigin().getName();
        this.typeName = product.getType().getName();
        //HashSet<ProductFlavor> fhgbjh = product.getFlavors();
        //this.flavors = setDtoFlavors(product.getFlavors());
    }

    @Autowired
    public Product toProduct(ProductOriginServiceImpl originService, ProductTypeServiceImpl typeService,
                             ProductFlavorServiceImpl flavorService){
        Product product = new Product();
        product.setName(name);
        product.setDescription(description);
        product.setImage(image);
        product.setPrice(price);
        product.setType(typeService.findTypeByName(typeName));
        product.setOrigin(originService.findOriginByName(originName));
       // product.setFlavors(setDtoFlavors1(flavors, flavorService));
        return product;
    }

    public Set<String> setDtoFlavors(Set<ProductFlavor> flavors){
        var productDtoFlavors = new HashSet<String>();
        for(ProductFlavor flavor : flavors){
            productDtoFlavors.add(flavor.getName());
        }
        return productDtoFlavors;
    }

//    public Set<ProductFlavor> setDtoFlavors1(List<String> flavors, ProductFlavorServiceImpl flavorService){
//        var flavorsPr = new HashSet<ProductFlavor>();
//        for(String flavor : flavors){
//            flavorsPr.add(flavorService.findFlavorByName(flavor));
//        }
//        return flavorsPr;
//    }
}
