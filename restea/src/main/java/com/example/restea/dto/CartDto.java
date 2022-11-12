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

//    public CartDto(Long userId, CartService cartService, ProductService productService) {
//        this.userId = userId;
//        this.products = cartService.getCartProductsByUserId(this.userId, productService);
//    }
}
