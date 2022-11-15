package com.example.restea.service.impl;

import com.example.restea.model.Product;
import com.example.restea.repository.ProductRepository;
import com.example.restea.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product findProductById(Long id) {
        return productRepository.findById(id).get();
    }

    @Override
    public List<Product> findAll() {
        List<Product> listOfProducts = new ArrayList<>();
        var iterableProducts = productRepository.findAll();
        iterableProducts.forEach(listOfProducts::add);
        return listOfProducts;
    }

    @Override
    public List<Product> getProductsForMainPage() {
        return this.findAll().stream().limit(4).collect(Collectors.toList());
    }

    @Override
    public JSONObject minMaxProductPrice() {
        JSONObject minMaxPriceJsonObject = new JSONObject();
        minMaxPriceJsonObject.put("min", productRepository.minProductPrice());
        minMaxPriceJsonObject.put("max", productRepository.maxProductPrice());
        return minMaxPriceJsonObject;
    }

    @Override
    public void addProduct(Product product) {
        productRepository.save(product);
    }
}
