package com.example.order_application.services;

import com.example.order_application.entities.OrderDetail;

import java.util.List;

public interface OrderDetailService {
    OrderDetail addOrderDetail(OrderDetail orderDetail);

    OrderDetail updateOrderDetail(Long id, OrderDetail orderDetail);

    OrderDetail getOrderDetailById(Long id);

    List<OrderDetail> getAllOrderDetails();

    void deleteOrderDetail(Long id);
}

