package com.example.restea.service.impl;

import com.example.restea.dto.CartProductDto;
import com.example.restea.dto.OrderDto;
import com.example.restea.model.Order;
import com.example.restea.model.OrderProduct;
import com.example.restea.model.OrderProductId;
import com.example.restea.repository.CartRepository;
import com.example.restea.repository.OrderProductRepository;
import com.example.restea.repository.OrderRepository;
import com.example.restea.service.CartService;
import com.example.restea.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final CartRepository cartRepository;

    private final OrderProductRepository orderProductRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, CartRepository cartRepository,
                            OrderProductRepository orderProductRepository) {
        this.orderRepository = orderRepository;
        this.cartRepository = cartRepository;
        this.orderProductRepository = orderProductRepository;
    }

    @Override
    public Order addOrder(Order order, Long userId, CartService cartService) {
        List<CartProductDto> products = cartService.getCartProductsByUserId(userId);
        if (products.isEmpty()) {
            return null;
        }
        order.setUserId(userId);
        var addedOrder = orderRepository.save(order);
        cartProductsToOrderProducts(products, order.getId());
        cartRepository.deleteAllByUserId(userId);
        return addedOrder;
    }

    @Override
    public List<OrderDto> findAllUserOrders(Long userId) {
        List<Order> userOrders = orderRepository.findAllByUserIdOrderByOrderDataDesc(userId);
        return ordersListToOrdersDtoList(userOrders);
    }

    private void cartProductsToOrderProducts(List<CartProductDto> cartProductsDto, Long orderId) {
        for (CartProductDto cartProduct : cartProductsDto) {
            OrderProduct orderProduct = new OrderProduct();
            Long cartProductId = cartProduct.getProduct().getId();
            orderProduct.setId(new OrderProductId(orderId, cartProductId));
            orderProduct.setWeight(cartProduct.getProductWeight());
            orderProductRepository.save(orderProduct);
        }
    }

    private List<OrderDto> ordersListToOrdersDtoList(List<Order> orders) {
        List<OrderDto> ordersDto = new ArrayList<>();
        for (Order order : orders) {
            OrderDto orderDto = new OrderDto(order);
            ordersDto.add(orderDto);
        }
        return ordersDto;
    }
}
