package com.yan.springbootmall.service;

import com.yan.springbootmall.dto.CreateOrderRequest;
import com.yan.springbootmall.model.Order;

public interface OrderService {
    Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest);

    Order getOrderById(Integer orderId);
}
