package com.example.restea.dto;

import com.example.restea.model.Cart;
import com.example.restea.model.Product;
import com.example.restea.repository.CartRepository;
import com.example.restea.service.CartService;
import com.example.restea.service.ProductService;
import com.example.restea.service.impl.CartServiceImpl;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Getter
@Setter
@NoArgsConstructor
public class CartDto {
    private Long userId;
    private List<CartProductDto> products;

    public CartDto(Long userId, CartService cartService, ProductService productService) {
        this.userId = userId;
        this.products = getCartProductsByUserId(this.userId, cartService, productService);
    }
    private Map<Long, List<CartProductDto>> groupCartProductsByUser(CartService cartService,
                                                                    ProductService productService) {
        List<Cart> carts = cartService.findAll();
        Map<Long, List<CartProductDto>> listOfProductsByUserId = new TreeMap<>();
        for(Cart cart : carts){
            List<CartProductDto> cartProductsDto;
            if(listOfProductsByUserId.containsKey(cart.getId().getUserId())){
                cartProductsDto = listOfProductsByUserId.get(cart.getId().getUserId());
            } else{
                cartProductsDto = new ArrayList<>();
            }
            cartProductsDto.add(new CartProductDto(cart, productService));
            listOfProductsByUserId.put(cart.getId().getUserId(), cartProductsDto);
        }
        return listOfProductsByUserId;
    }

    public List<CartProductDto> getCartProductsByUserId(Long userId, CartService cartService,
                                                        ProductService productService) {
        Map<Long, List<CartProductDto>> groupCartProductsByUser = this.groupCartProductsByUser(cartService,
                productService);
        return groupCartProductsByUser.get(userId);
    }
}
