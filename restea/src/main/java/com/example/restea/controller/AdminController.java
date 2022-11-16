package com.example.restea.controller;

import com.example.restea.dto.ProductDto;
import com.example.restea.service.ProductService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/admin")
public class AdminController {

    private final ProductService productService;

    @Autowired
    public AdminController(ProductService productService) {
        this.productService = productService;
    }

    /**
     * Method for add product to db(admin panel).
     *
     * @return {@link ProductDto} instance.
     * @author Iryna Kopchak.
     */
    @PostMapping(value = "/add-product")
    @SecurityRequirement(name = "Bearer Authentication")
    public ResponseEntity<ProductDto> addProduct(@RequestBody ProductDto product) {
        try {
            productService.addProduct(product);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
