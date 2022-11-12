package com.example.restea.dto;

import com.example.restea.model.OrderProduct;
import com.example.restea.model.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
@NoArgsConstructor
public class OrderProductDto {
    private Long productId;

    private int weight;

    public OrderProductDto(OrderProduct orderProduct){
        this.productId = orderProduct.getId().getProductId();;
        this.weight = orderProduct.getWeight();
    }
}
