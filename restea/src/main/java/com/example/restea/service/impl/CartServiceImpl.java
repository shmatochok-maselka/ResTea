package com.example.restea.service.impl;

import com.example.restea.dto.CartProductDto;
import com.example.restea.dto.ProductDto;
import com.example.restea.model.Cart;
import com.example.restea.model.CartId;
import com.example.restea.model.Product;
import com.example.restea.model.User;
import com.example.restea.repository.BlogPostRepository;
import com.example.restea.repository.CartRepository;
import com.example.restea.repository.ProductRepository;
import com.example.restea.service.CartService;
import com.example.restea.service.ProductService;
import com.example.restea.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.security.Principal;
import java.util.*;

@Service
@Transactional
public class CartServiceImpl implements CartService {
    private CartRepository cartRepository;
    private ProductService productService;
    private UserService userService;

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
    public List<Cart> findByUserId(Long userId) {
        List<Cart> allCartProducts = this.findAll();
        List<Cart> userProductCarts = new ArrayList<>();
        for(Cart cart: allCartProducts){
            if(cart.getId().getUserId() == userId)
                userProductCarts.add(cart);
        }
        return userProductCarts;
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

    private List<CartProductDto> objectListToCartProduct(List<Object[]> cartProductsObject){
        List<CartProductDto> cartProductsDto = new ArrayList<>();
        for(Object[] objects : cartProductsObject){
            CartProductDto cartProductDto = new CartProductDto(new ProductDto((Product) objects[0]), (Integer) objects[1]);
            cartProductsDto.add(cartProductDto);
        }
        return cartProductsDto;
    }
//    @Override
//    public void addProductToCart(Cart cart) {
//        cartRepository.save(cart);
//    }
    @Override
    public ResponseEntity<Object> addProductToCart(Map<String, Long> productCartJSON, Principal principal) {
        if (!productCartJSON.containsKey("productId") || !productCartJSON.containsKey("productWeight")) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Long productId = productCartJSON.get("productId");
        Long userId = userService.findUserByEmail(principal.getName()).getId();
        try{
            Product product = productService.findProductById(productId);
        } catch (NoSuchElementException exception){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Cart cartProduct = new Cart();
        cartProduct.setId(new CartId(userId, productId));
        try{
            Cart cartProductExist = findById(new CartId(userId, productId));
            cartProduct.setProductWeight(productCartJSON.get("productWeight").intValue() +
                    cartProductExist.getProductWeight());
        }catch (Exception e){
            cartProduct.setProductWeight(productCartJSON.get("productWeight").intValue());
        }
        cartRepository.save(cartProduct);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


//    private Map<Long, List<CartProductDto>> groupCartProductsByUser(ProductService productService) {
//        List<Cart> carts = cartRepository.findAll();
//        Map<Long, List<CartProductDto>> listOfProductsByUserId = new TreeMap<>();
//        for(Cart cart : carts){
//            List<CartProductDto> cartProductsDto;
//            if(listOfProductsByUserId.containsKey(cart.getId().getUserId())){
//                cartProductsDto = listOfProductsByUserId.get(cart.getId().getUserId());
//            } else{
//                cartProductsDto = new ArrayList<>();
//            }
//            cartProductsDto.add(new CartProductDto(cart, productService));
//            listOfProductsByUserId.put(cart.getId().getUserId(), cartProductsDto);
//        }
//        return listOfProductsByUserId;
//    }
//
//    @Override
//    public List<CartProductDto> getCartProductsByUserId(Long userId, ProductService productService) {
//        Map<Long, List<CartProductDto>> groupCartProductsByUser = this.groupCartProductsByUser(productService);
//        return groupCartProductsByUser.get(userId);
//    }

}
