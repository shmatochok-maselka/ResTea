package com.example.restea.dto;

import com.example.restea.model.Cart;
import com.example.restea.model.Product;
import com.example.restea.model.ProductFlavor;
import com.example.restea.service.ProductService;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Getter
@Setter
@NoArgsConstructor
public class CartProductDto {
    private ProductDto product;
    private int productWeight;

    public CartProductDto(ProductDto product, int productWeight) {
        this.product = product;
        this.productWeight = productWeight;
    }
//    public CartProductDto(Cart cart, ProductService productService) {
//        this.product = productService.findProductById(cart.getId().getProductId());
////        this.productId = cart.getId().getProductId();
////        Product product = productService.findProductById(cart.getId().getProductId());
////        this.productName = product.getName();
////        this.productImage = product.getImage();
////        this.productPrice = product.getPrice();
//        this.productWeight = cart.getProductWeight();
//    }
}
