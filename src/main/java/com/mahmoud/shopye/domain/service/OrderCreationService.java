package com.mahmoud.shopye.domain.service;

import com.mahmoud.shopye.domain.model.Order;
import com.mahmoud.shopye.domain.port.in.OrderCreation;
import com.mahmoud.shopye.domain.port.out.OrderCreationRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class OrderCreationService implements OrderCreation {
    private final OrderCreationRepository orderCreationRepository;
    @Override
    public Order createOrder(List<Long> productIds, Long retailerId) {
        var retailer = orderCreationRepository.getRetailerWithWriteLock(retailerId).orElseThrow();

        var products = orderCreationRepository.getProductsWithWriteLock(productIds);

        var order = Order.of(retailer, products);

        if (!order.isRetailerCanCreateOrder())
            throw new RuntimeException("Retailer can create order");

        return this.orderCreationRepository.SaveOrder(order);
    }
}
