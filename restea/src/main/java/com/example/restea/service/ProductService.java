package com.example.restea.service;

import com.example.restea.model.Product;
import org.json.JSONObject;

import java.util.List;

public interface ProductService {
    Product findProductById(Long id);
    List<Product> findAll();
    List<Product> getProductsForMainPage();

    JSONObject minMaxProductPrice();

}
