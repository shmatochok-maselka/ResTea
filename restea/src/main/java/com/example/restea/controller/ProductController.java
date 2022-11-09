package com.example.restea.controller;

import com.example.restea.dto.ProductDto;
import com.example.restea.model.Product;
import com.example.restea.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/products")
public class ProductController {
    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<ProductDto>> findAllProducts() {
        return new ResponseEntity<>(productService.findAll().stream()
                .map(ProductDto::new)
                .collect(Collectors.toList()),
                HttpStatus.OK);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ProductDto> findProductById(@PathVariable Long productId) {
        if (productId == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        try {
            Product product = productService.findProductById(productId);
        } catch (NoSuchElementException exception) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(new ProductDto(productService.findProductById(productId)),
                HttpStatus.OK);
    }

}
