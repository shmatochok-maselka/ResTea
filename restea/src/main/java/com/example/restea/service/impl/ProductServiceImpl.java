package com.example.restea.service.impl;

import com.example.restea.dto.MainPageProductDto;
import com.example.restea.model.Product;
import com.example.restea.repository.ProductRepository;
import com.example.restea.service.ProductService;
import lombok.extern.slf4j.Slf4j;
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
    public List<MainPageProductDto> getProductsForMainPage() {
        List<Product> products = this.findAll().stream().limit(4).collect(Collectors.toList());
        return productListToProductDtoList(products);
    }

    @Override
    public int minProductPrice() {
        return productRepository.minProductPrice();
    }

    @Override
    public int maxProductPrice() {
        return productRepository.maxProductPrice();
    }

    private List<MainPageProductDto> productListToProductDtoList(List<Product> products){
        List<MainPageProductDto> productsDto = new ArrayList<>();
        for (Product product: products){
            productsDto.add(new MainPageProductDto(product));
        }
        return productsDto;
    }


//    @Override
//    public List<ProductDto> findAll() {
//        return productSetToProductDtoSet(productRepository.findAll());
//    }
//
//    @Override
//    public List<ProductDto> productSetToProductDtoSet(List<Product> products) {
//        List<ProductDto> productsDto = new ArrayList<>();
//        for (Product product : products){
//            var productDto = new ProductDto();
//            productDto.setId(product.getId());
//            productDto.setName(product.getName());
//            productsDto.add(productDto);
//        }
//        return productsDto;
//    }
}
