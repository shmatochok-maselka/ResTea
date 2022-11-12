package com.example.restea.controller;

import com.example.restea.dto.CartProductDto;
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

import java.security.Principal;
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

    @GetMapping
    public ResponseEntity<List<CartProductDto>> findAllCartProducts(Principal principal) {
        Long userId = userService.findUserByEmail(principal.getName()).getId();
        return new ResponseEntity<>(cartService.getCartProductsByUserId(userId), HttpStatus.CREATED);
    }

    @PostMapping(value = "/delete")
    public ResponseEntity<List<Cart>> deleteProductFromCart(@RequestBody Map<String, Long> productCartJSON) {
        if (productCartJSON == null || !productCartJSON.containsKey("productId")) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Long productId = productCartJSON.get("productId");
        Long userId = productCartJSON.get("userId");
        try {
            Product product = productService.findProductById(productId);
            User user = userService.findUserById(userId);
        } catch (NoSuchElementException exception) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Cart cartProduct = new Cart();
        CartId cartId = new CartId(userId, productId);
        cartProduct.setId(cartId);
        if (cartService.findById(cartId) != null) {
            cartService.deleteById(cartId);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping(value = "/add")
    public ResponseEntity<Object> addProductToCart(@RequestBody Map<String, Long> productCartJSON, Principal principal) {
        return cartService.addProductToCart(productCartJSON, principal);
    }
}
