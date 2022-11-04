package com.example.restea.controller;

import com.example.restea.model.Cart;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/cart")
public class CartController {

    @PostMapping
    public ResponseEntity<Cart>(@JsonArg("/userId") userId, @JsonArg("/productId") productId, ){

    }
}
