package com.example.restea.service;

import com.example.restea.dto.ProductDto;
import com.example.restea.model.Product;

import java.util.List;

public interface ProductService {
    Product findProductById(Long id);
    List<Product> findAll();
    List<ProductDto> getProductsForMainPage();

    int minProductPrice();

    int maxProductPrice();
}
