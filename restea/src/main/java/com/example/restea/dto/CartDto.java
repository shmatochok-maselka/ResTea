package com.example.restea.dto;

import com.example.restea.model.Cart;
import com.example.restea.repository.CartRepository;
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
    private List<CartProductDto> products;
    @Autowired
    private CartRepository cartRepository;

    private CartServiceImpl cartService = new CartServiceImpl(cartRepository);

    public CartDto(Cart cart) {
        this.userId = cart.getUser().getId();
        this.products = cartService.groupCartProductsByUser().get(this.userId);
    }
}
