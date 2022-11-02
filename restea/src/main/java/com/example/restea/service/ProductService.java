package com.example.restea.service;

import com.example.restea.model.Product;

import java.util.List;
import java.util.Set;

public interface ProductService {
    Product findProductById(Long id);

    List<Product> findAll();

}
