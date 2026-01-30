package com.atguigu.order.service;

import com.atguigu.order.bean.Order;

public interface OrderService {

    /*
     * 创建订单
     */
    Order createOrder(Long productId, Long userId);
}
