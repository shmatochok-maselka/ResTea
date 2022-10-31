package com.example.restea.service;

import com.example.restea.model.Product;

import java.util.List;

public interface ProductService {
    Product getById(Long product_id);

    void save(Product product);

    void delete(Long product_id);

    List<Product> getAll();
}
