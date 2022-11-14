package com.example.restea.service.impl;

import com.example.restea.dto.CartProductDto;
import com.example.restea.dto.OrderDto;
import com.example.restea.model.Order;
import com.example.restea.model.OrderProduct;
import com.example.restea.model.OrderProductId;
import com.example.restea.repository.CartRepository;
import com.example.restea.repository.OrderProductRepository;
import com.example.restea.repository.OrderRepository;
import com.example.restea.repository.ProductFlavorsRepository;
import com.example.restea.service.CartService;
import com.example.restea.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
public class OrderServiceImpl implements OrderService {
    private OrderRepository orderRepository;
    private CartRepository cartRepository;

    private OrderProductRepository orderProductRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, CartRepository cartRepository,
                            OrderProductRepository orderProductRepository) {
        this.orderRepository = orderRepository;
        this.cartRepository = cartRepository;
        this.orderProductRepository = orderProductRepository;
    }

    @Override
    public Order addOrder(Order order, Long userId, CartService cartService) {
        var addedOrder = orderRepository.save(order);
        List<CartProductDto> products = cartService.getCartProductsByUserId(userId);
        cartProductsToOrderProducts(products, order.getId());
        cartRepository.deleteAllByUserId(userId);
        return addedOrder;
    }

    private void cartProductsToOrderProducts(List<CartProductDto> cartProductsDto, Long orderId){
        for (CartProductDto cartProduct : cartProductsDto){
            OrderProduct orderProduct = new OrderProduct();
                Long cartProductId = cartProduct.getProduct().getId();
                orderProduct.setId(new OrderProductId(orderId, cartProductId));
                orderProduct.setWeight(cartProduct.getProductWeight());
                orderProductRepository.save(orderProduct);
            }
    }

    @Override
    public Order findByUserIdAndOrderData(Long userId, LocalDateTime orderData) {
        return orderRepository.findByUserIdAndOrderData(userId, orderData).get(1);
    }
}
