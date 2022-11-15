package com.example.restea.service.impl;

import com.example.restea.dto.CartAddDto;
import com.example.restea.dto.CartProductDto;
import com.example.restea.model.Cart;
import com.example.restea.model.CartId;
import com.example.restea.model.Product;
import com.example.restea.repository.CartRepository;
import com.example.restea.service.CartService;
import com.example.restea.service.ProductService;
import com.example.restea.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@Service
@Transactional
public class CartServiceImpl implements CartService {
    private final CartRepository cartRepository;
    private final ProductService productService;
    private final UserService userService;

    @Autowired
    public CartServiceImpl(CartRepository cartRepository, ProductService productService, UserService userService) {
        this.cartRepository = cartRepository;
        this.productService = productService;
        this.userService = userService;
    }

    @Override
    public List<Cart> findAll() {
        return cartRepository.findAll();
    }

    @Override
    public void deleteById(CartId cardId) {
        cartRepository.delete(this.findById(cardId));
    }


    @Override
    public Cart findById(CartId cartId) {
        return cartRepository.findById(cartId).orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public List<CartProductDto> getCartProductsByUserId(Long userId) {
        List<Object[]> cartProducts = cartRepository.findAllCartProductsByUserId(userId);
        return objectListToCartProduct(cartProducts);
    }

    private List<CartProductDto> objectListToCartProduct(List<Object[]> cartProductsObject) {
        List<CartProductDto> cartProductsDto = new ArrayList<>();
        for (Object[] objects : cartProductsObject) {
            CartProductDto cartProductDto = new CartProductDto((Product) objects[0], (Integer) objects[1]);
            cartProductsDto.add(cartProductDto);
        }
        return cartProductsDto;
    }

    @Override
    public ResponseEntity<Object> addProductToCart(Map<String, Long> productCartJSON, Principal principal) {
        Long productId = productCartJSON.get("productId");
        Long userId = userService.findUserByEmail(principal.getName()).getId();
        try {
            productService.findProductById(productId);
        } catch (NoSuchElementException exception) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Cart cartProduct = new Cart();
        cartProduct.setId(new CartId(userId, productId));
        try {
            Cart cartProductExist = findById(new CartId(userId, productId));
            cartProduct.setProductWeight(productCartJSON.get("productWeight").intValue() +
                    cartProductExist.getProductWeight());
        } catch (Exception e) {
            cartProduct.setProductWeight(productCartJSON.get("productWeight").intValue());
        }
        cartRepository.save(cartProduct);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }



//    @Override
//    public void updateProductCart(Long userId, Long productId, int productWeight) {
//        cartRepository.updateCartProduct(new CartId(userId, productId), productWeight);
//    }

    @Override
    public void updateProductCart(Long userId, CartAddDto cartAddDto) {
        Long productId = cartAddDto.getProductId();
        int productWeight = cartAddDto.getProductWeight();
        cartRepository.updateCartProduct(new CartId(userId, productId), productWeight);
    }
}
