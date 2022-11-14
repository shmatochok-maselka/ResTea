package com.example.restea.controller;

import com.example.restea.dto.CartProductDto;
import com.example.restea.model.CartId;
import com.example.restea.service.CartService;
import com.example.restea.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/cart")
public class CartController {

    private final CartService cartService;
    private final UserService userService;


    @Autowired
    public CartController(CartService cartService, UserService userService) {
        this.cartService = cartService;
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<CartProductDto>> findAllCartProducts(Principal principal) {
        Long userId = userService.findUserByEmail(principal.getName()).getId();
        return new ResponseEntity<>(cartService.getCartProductsByUserId(userId), HttpStatus.CREATED);
    }

    @PostMapping(value = "/add")
    public ResponseEntity<Object> addProductToCart(@RequestBody Map<String, Long> productCartJSON, Principal principal) {
        return cartService.addProductToCart(productCartJSON, principal);
    }

    @PutMapping
    public ResponseEntity<Object> editProductCart(@RequestBody Map<String, Long> productCartJSON, Principal principal) {
        if (productCartJSON == null || !productCartJSON.containsKey("productId") ||
                !productCartJSON.containsKey("productWeight")) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Long productId = productCartJSON.get("productId");
        int productWeight = productCartJSON.get("productWeight").intValue();
        Long userId = userService.findUserByEmail(principal.getName()).getId();
        cartService.updateProductCart(userId, productId, productWeight);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "/delete")
    public ResponseEntity<Object> deleteProductFromCart(@RequestBody Map<String, Long> productCartJSON, Principal principal) {
        if (productCartJSON == null || !productCartJSON.containsKey("productId")) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Long productId = productCartJSON.get("productId");
        Long userId = userService.findUserByEmail(principal.getName()).getId();
        try {
            cartService.deleteById(new CartId(userId, productId));
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
