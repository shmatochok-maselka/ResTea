package com.example.restea.controller;

import com.example.restea.dto.CartDto;
import com.example.restea.model.Cart;
import com.example.restea.model.CartId;
import com.example.restea.model.Product;
import com.example.restea.model.User;
import com.example.restea.service.CartService;
import com.example.restea.service.ProductService;
import com.example.restea.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

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
        try{
            User user = userService.findUserById(userId);
        } catch (NoSuchElementException exception){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        CartDto cartProducts = new CartDto(userId, cartService, productService);
        return new ResponseEntity<>(cartProducts, HttpStatus.CREATED);
    }

    @PostMapping(value = "/delete")
    public ResponseEntity<List<Cart>> deleteProductfromCart(@RequestBody Map<String, Long> productCartJSON) {
        if (productCartJSON == null || !productCartJSON.containsKey("userId") ||
                !productCartJSON.containsKey("productId")) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Long productId = productCartJSON.get("productId");
        Long userId = productCartJSON.get("userId");
        try{
            Product product = productService.findProductById(productId);
            User user = userService.findUserById(userId);
        } catch (NoSuchElementException exception){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Cart cartProduct = new Cart();
        CartId cartId = new CartId(userId, productId);
        cartProduct.setId(cartId);
        if(cartService.findById(cartId) != null){
            cartService.deleteById(cartId);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping(value = "/add")
    public ResponseEntity<List<Cart>> addProductToCart(@RequestBody Map<String, Long> productCartJSON) {
        if (productCartJSON == null || !productCartJSON.containsKey("userId") || !productCartJSON.containsKey("productId")
            || !productCartJSON.containsKey("productWeight")) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Long productId = productCartJSON.get("productId");
        Long userId = productCartJSON.get("userId");
        try{
            Product product = productService.findProductById(productId);
            User user = userService.findUserById(userId);
        } catch (NoSuchElementException exception){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Cart cartProduct = new Cart();
        cartProduct.setId(new CartId(userId, productId));
        Cart cartProductExist = cartService.findById(new CartId(userId, productId));
        if(cartProductExist != null){
            cartProduct.setProductWeight(productCartJSON.get("productWeight").intValue() +
                    cartProductExist.getProductWeight());
        }else{
            cartProduct.setProductWeight(productCartJSON.get("productWeight").intValue());
        }
        cartService.addProductToCart(cartProduct);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
