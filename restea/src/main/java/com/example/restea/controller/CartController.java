package com.example.restea.controller;

import com.example.restea.dto.CartDto;
import com.example.restea.dto.CartProductDto;
import com.example.restea.model.Cart;
import com.example.restea.model.CartId;
import com.example.restea.model.Product;
import com.example.restea.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
    public ResponseEntity<CartDto> findAllCartProducts(@RequestBody Map<String, Long> productCartJSON) {
        if (productCartJSON == null || !productCartJSON.containsKey("userId")) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Long userId = productCartJSON.get("userId");
        CartDto cartProducts = new CartDto(userId, cartService, productService);
        return new ResponseEntity<>(cartProducts, HttpStatus.CREATED);
    }

    @PostMapping(value = "/add")
    public ResponseEntity<List<Cart>> addProductToCart(@RequestBody Map<String, Long> productCartJSON) {
        if (productCartJSON == null || !productCartJSON.containsKey("userId") || !productCartJSON.containsKey("productId")
            || !productCartJSON.containsKey("productWeight")) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Cart cartProduct = new Cart();
        cartProduct.setId(new CartId(productCartJSON.get("userId"), productCartJSON.get("productId")));
//        cartProduct.setUser(userService.findUserById(productCartJSON.get("userId")));
//        cartProduct.setCartProduct(productService.findProductById(productCartJSON.get("productId")));
        cartProduct.setProductWeight(productCartJSON.get("productWeight").intValue());
        cartService.addProductToCart(cartProduct);
//        return new ResponseEntity<>(cartService.getCartProductsByUserId(productCartJSON.get("userId")), HttpStatus.CREATED);
        return new ResponseEntity<>(cartService.findById_OrderCode(productCartJSON.get("userId")), HttpStatus.CREATED);
    }
}
