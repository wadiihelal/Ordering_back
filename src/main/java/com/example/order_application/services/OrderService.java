package com.example.order_application.services;

import com.example.order_application.entities.Order;

import java.util.List;

public interface OrderService {
    Order createOrder(Order order);

    Order updateOrder(Long id, Order order);

    Order getOrderById(Long id);

    List<Order> getAllOrders();

    void deleteOrder(Long id);
}
