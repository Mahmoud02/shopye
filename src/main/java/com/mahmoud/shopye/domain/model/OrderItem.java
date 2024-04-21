package com.mahmoud.shopye.domain.model;

import java.util.ArrayList;
import java.util.List;

public class OrderItem {
    private Long id;
    private Order order;
    private Product product;
    private int quantity;

    public double getPrice(){
        return product.getPrice()* quantity;
    }

    public static List<OrderItem> of (List<Product> products){
        List<OrderItem> orderItems = new ArrayList<>();
        for (Product product : products) {
            OrderItem orderItem = new OrderItem();
            orderItem.product = product;
            orderItem.quantity = 0;
            orderItems.add(orderItem);
        }
        return orderItems;
    }
    public static double getTotalPriceOfOrderItems(List<OrderItem> orderItems){
        var totalPrice = 0.0;
        for (OrderItem orderItem : orderItems) {
            if (orderItem.product != null) {
               totalPrice += orderItem.product.getPrice() * orderItem.quantity;
            }
        }
        return totalPrice;
    }
}
