package com.example.restea.service;

import com.example.restea.dto.ProductDto;
import com.example.restea.dto.ProductFlavorDto;
import com.example.restea.model.Product;
import com.example.restea.model.ProductFlavor;

import java.util.List;
import java.util.Set;

public interface ProductService {
    Product findProductById(Long id);

//    Set<ProductDto> findAll();
    List<Product> findAll();
//    List<ProductDto> productSetToProductDtoSet(List<Product> productsDto);
}
