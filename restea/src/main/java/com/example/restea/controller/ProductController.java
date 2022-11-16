package com.example.restea.controller;

import com.example.restea.dto.BlogPostDto;
import com.example.restea.dto.ProductDto;
import com.example.restea.model.Product;
import com.example.restea.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/products")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    /**
     * Method for return all products.
     *
     * @return {@link ProductDto} instance.
     * @author Iryna Kopchak.
     */
    @GetMapping
    public ResponseEntity<List<ProductDto>> findAllProducts() {
        return new ResponseEntity<>(productService.findAllProducts(), HttpStatus.OK);
    }

    /**
     * Method for return product by id.
     *
     * @return {@link ProductDto} instance.
     * @author Iryna Kopchak.
     */
    @GetMapping("/{productId}")
    public ResponseEntity<ProductDto> findProductById(@PathVariable Long productId) {
        if (productId == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        try {
            productService.findProductById(productId);
        } catch (NoSuchElementException exception) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(productService.findProductById(productId), HttpStatus.OK);
    }

    /**
     * Method for add product to db(admin panel).
     *
     * @return {@link ProductDto} instance.
     * @author Iryna Kopchak.
     */
    @PostMapping(value = "/add-product")
    public ResponseEntity<ProductDto> addProduct(@RequestBody ProductDto product) {
        try {
            productService.addProduct(product);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
