package com.example.restea.dto;

import com.example.restea.model.Cart;
import com.example.restea.model.Product;
import com.example.restea.repository.CartRepository;
import com.example.restea.service.CartService;
import com.example.restea.service.impl.CartServiceImpl;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class CartDto {
    private Long userId;
    private List<Product> products;

    public CartDto(Cart cart) {
        this.userId = cart.getId().getUserId();
        this.products = cart.getCartProducts();
    }
}
