package com.mahmoud.shopye.domain.port.in;

import com.mahmoud.shopye.domain.model.Order;

import java.util.List;

public interface OrderCreation {
    Order createOrder(List<Long> productIds , Long retailerId);
}
