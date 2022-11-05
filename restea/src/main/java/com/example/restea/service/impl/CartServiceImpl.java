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

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Service
@Transactional
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
    public List<Cart> findById_OrderCode(Long userId) {
        List<Cart> carts = this.findAll();
        List<Cart> newCarts = new ArrayList<>();
        for(Cart cart: carts){
            if(cart.getId().getUserId() == userId)
                newCarts.add(cart);
        }
        return newCarts;
    }

    @Override
    public void addProductToCart(Cart cart) {
        cartRepository.save(cart);
    }

//    @Override
    private Map<Long, List<CartProductDto>> groupCartProductsByUser() {
        List<Cart> carts = cartRepository.findAll();
        Map<Long, List<CartProductDto>> listOfProductsByUserId = new TreeMap<>();
        for(Cart cart : carts){
            List<CartProductDto> cartProductsDto;
            if(listOfProductsByUserId.containsKey(cart.getId().getUserId())){
                cartProductsDto = listOfProductsByUserId.get(cart.getId().getUserId());
            } else{
                cartProductsDto = new ArrayList<>();
            }
            cartProductsDto.add(new CartProductDto(cart));
            listOfProductsByUserId.put(cart.getId().getUserId(), cartProductsDto);
        }
        return listOfProductsByUserId;
    }

    @Override
    public List<CartProductDto> getCartProductsByUserId(Long userId) {
        Map<Long, List<CartProductDto>> groupCartProductsByUser = this.groupCartProductsByUser();
        return groupCartProductsByUser.get(userId);
    }

}
