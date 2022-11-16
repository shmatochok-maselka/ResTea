package com.example.restea.service;

import com.example.restea.dto.ProductDto;
import com.example.restea.model.Product;
import org.json.JSONObject;

import java.util.List;

public interface ProductService {
    ProductDto findProductById(Long id);

    List<ProductDto> findAllProducts();

    List<ProductDto> getProductsForMainPage();

    JSONObject minMaxProductPrice();

    void addProduct(ProductDto product);
}
