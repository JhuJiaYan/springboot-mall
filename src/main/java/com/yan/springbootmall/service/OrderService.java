package com.yan.springbootmall.service;

import com.yan.springbootmall.dto.CreateOrderRequest;
import com.yan.springbootmall.dto.OrderQueryParams;
import com.yan.springbootmall.model.Order;

import java.util.List;

public interface OrderService {
    Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest);

    Order getOrderById(Integer orderId);

    List<Order> getOrders(OrderQueryParams orderQueryParams);

    Integer countOrder(OrderQueryParams orderQueryParams);
}
