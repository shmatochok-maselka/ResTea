package com.example.restea.service.impl;

import com.example.restea.model.Product;
import com.example.restea.repository.ProductRepository;
import com.example.restea.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return productRepository.findAll();
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
