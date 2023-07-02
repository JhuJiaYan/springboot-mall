package com.yan.springbootmall.service.Impl;

import com.yan.springbootmall.dao.OrderDao;
import com.yan.springbootmall.dao.ProductDao;
import com.yan.springbootmall.dto.BuyItem;
import com.yan.springbootmall.dto.CreateOrderRequest;
import com.yan.springbootmall.model.Order;
import com.yan.springbootmall.model.OrderItem;
import com.yan.springbootmall.model.Product;
import com.yan.springbootmall.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private ProductDao productDao;

    @Transactional
    @Override
    public Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest) {

        int totalAmount = 0;
        List<OrderItem> orderItemList = new ArrayList<>();

        for (BuyItem buyItem : createOrderRequest.getBuyItemList()) {
            Product product = productDao.getProductById(buyItem.getProductId());

            //計算總價錢
            int amount = buyItem.getQuantity() * product.getPrice();
            totalAmount = totalAmount + amount;

            //轉換 BuyItem to OrderItem
            OrderItem orderItem = new OrderItem();
            orderItem.setProductId(buyItem.getProductId());
            orderItem.setQuantity(buyItem.getQuantity());
            orderItem.setAmount(amount);

            orderItemList.add(orderItem);
        }

        //創建訂單(主表)
        Integer orderId = orderDao.createOrder(userId, totalAmount);
        //創建訂單(細項清單)
        orderDao.createOrderItems(orderId, orderItemList);
        return orderId;
    }

    @Override
    public Order getOrderById(Integer orderId) {
        Order order = orderDao.getOrderById(orderId);//取得主表數據
        List<OrderItem> orderItemList = orderDao.getOrderItemByOrderId(orderId);//取得細項List數據
        order.setOrderItemList(orderItemList);//將細項List數據加入到主表中
        return order;
    }
}
