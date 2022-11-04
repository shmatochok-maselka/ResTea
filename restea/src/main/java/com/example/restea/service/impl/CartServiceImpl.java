package com.example.restea.service.impl;

import com.example.restea.dto.CartProductDto;
import com.example.restea.model.Cart;
import com.example.restea.model.Product;
import com.example.restea.model.User;
import com.example.restea.repository.BlogPostRepository;
import com.example.restea.repository.CartRepository;
import com.example.restea.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Service
public class CartServiceImpl implements CartService {
    private CartRepository cartRepository;

    @Autowired
    public CartServiceImpl(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @Override
    public List<Cart> findAll() {
        return cartRepository.findAll();
    }

    @Override
    public Map<User, List<CartProductDto>> groupCartProductsByUser() {
        List<Cart> carts = cartRepository.findAll();
        Map<User, List<CartProductDto>> listOfProductsByUserId = new TreeMap<>();
        for(Cart cart : carts){
            List<CartProductDto> cartProductsDto;
            if(listOfProductsByUserId.containsKey(cart.getUser())){
                cartProductsDto = listOfProductsByUserId.get(cart.getUser());
            } else{
                cartProductsDto = new ArrayList<>();
            }
            cartProductsDto.add(new CartProductDto(cart));
            listOfProductsByUserId.put(cart.getUser(), cartProductsDto);
        }
        return listOfProductsByUserId;
    }

    @Override
    public void addProductToCart(Cart cart) {
        cartRepository.save(cart);
    }
}
