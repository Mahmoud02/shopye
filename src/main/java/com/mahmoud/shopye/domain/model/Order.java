package com.mahmoud.shopye.domain.model;

import lombok.Builder;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Builder
public class Order {
    private Long orderId;
    private Retailer retailer;
    private LocalDateTime orderDate;
    private ORDER_STATUS orderStatus;
    private List<OrderItem> orderItems;
    private Order() {};

    public static Order of(Retailer retailer, List<Product> products){
        var order = new Order();
        order.retailer = retailer;
        order.orderDate = LocalDateTime.now();
        order.orderStatus = ORDER_STATUS.ACCEPTED;
        order.orderItems = OrderItem.of(products);
        return order;
    }

    public boolean isRetailerCanCreateOrder(){
        if(!retailer.isRetailerEligibleForOrderCreation()){
            return false;
        }
        return !(OrderItem.getTotalPriceOfOrderItems(this.orderItems) > retailer.getBalance().doubleValue());
    }

}
 enum ORDER_STATUS {
    ACCEPTED,REJECTED,DELIVERED,FAILED_TO_DELIVER,REJECT;
}
