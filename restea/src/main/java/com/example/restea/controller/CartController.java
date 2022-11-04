package com.example.restea.controller;

import com.example.restea.dto.ProductDto;
import com.example.restea.dto.UserDto;
import com.example.restea.model.Cart;
import com.example.restea.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/cart")
public class CartController {

    private CartService cartService;
    private ProductService productService;
    private UserService userService;


    @Autowired
    public CartController(CartService cartService, ProductService productService, UserService userService) {
        this.cartService = cartService;
        this.productService = productService;
        this.userService = userService;
    }
    @PostMapping
    public ResponseEntity<Cart> addProductToCart(@RequestBody Map<String, Long> productCartJSON) {
        if (productCartJSON == null || !productCartJSON.containsKey("userId") || !productCartJSON.containsKey("productId")
            || !productCartJSON.containsKey("productWeight")) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Cart cartProduct = new Cart();
        cartProduct.setProduct(productService.findProductById(productCartJSON.get("productId")));
        cartProduct.setUser(userService.findUserById(productCartJSON.get("userId")));
        cartProduct.setProductWeight(productCartJSON.get("productWeight").intValue());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
