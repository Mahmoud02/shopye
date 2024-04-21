package com.mahmoud.shopye.domain.service;

import com.mahmoud.shopye.domain.model.Order;
import com.mahmoud.shopye.domain.port.in.OrderCreation;

import java.util.List;

public class OrderCreationService implements OrderCreation {
    @Override
    public Order createOrder(List<Long> productIds, Long retailerId) {
        return null;
    }
}
