package com.example.restea.controller;

import com.example.restea.dto.ProductDTO;
import com.example.restea.dto.UserDto;
import com.example.restea.model.User;
import com.example.restea.service.ProductService;
import com.example.restea.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<ProductDTO>> findAllUsers() {
        return new ResponseEntity<>(productService.getAll().stream().map(ProductDTO::new)
                .collect(Collectors.toList()),
                HttpStatus.OK);
    }

    /*@RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Product> getProduct(@PathVariable("id") Long productId){
        if(productId == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Product product = this.productService.getById(productId);
        if(product == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<Product>> getAll(){
        List<Product> products = productService.getAll();
//        if(products == null || products.isEmpty()){
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }*/
}
