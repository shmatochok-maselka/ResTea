package com.example.restea.controller;

import com.example.restea.dto.CartAddDto;
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

    /**
     * Method for return all cart products.
     *
     * @return {@link CartProductDto} instance.
     * @author Iryna Kopchak.
     */
    @GetMapping
    public ResponseEntity<List<CartProductDto>> findAllCartProducts(Principal principal) {
        Long userId = userService.findUserByIdPrincipal(principal);
        return new ResponseEntity<>(cartService.getCartProductsByUserId(userId), HttpStatus.CREATED);
    }

    /**
     * Method for add product to the cart.
     *
     * @return {@link CartProductDto} instance.
     * @author Iryna Kopchak.
     */
    @PostMapping(value = "/add")
    public ResponseEntity<CartProductDto> addProductToCart(@RequestBody CartAddDto cartAddDto, Principal principal) {
        try {
            cartService.addProductToCart(cartAddDto, principal);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * Method for update product in the cart.
     *
     * @return {@link CartProductDto} instance.
     * @author Iryna Kopchak.
     */
    @PutMapping
    public ResponseEntity<CartProductDto> editProductCart(@RequestBody CartAddDto cartAddDto, Principal principal) {
        try {
            Long userId = userService.findUserByIdPrincipal(principal);
            cartService.updateProductCart(userId, cartAddDto);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Method for delete product from the cart.
     *
     * @return {@link CartProductDto} instance.
     * @author Iryna Kopchak.
     */
    @PostMapping(value = "/delete")
    public ResponseEntity<Object> deleteProductFromCart(@RequestBody Map<String, Long> productCartJSON, Principal principal) {
        try {
            Long productId = productCartJSON.get("productId");
            Long userId = userService.findUserByIdPrincipal(principal);
            cartService.deleteById(new CartId(userId, productId));
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}