package com.atguigu.order.service.impl;
import java.math.BigDecimal;

import com.atguigu.order.bean.Order;
import com.atguigu.order.service.OrderService;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Override
    public Order createOrder(Long productId, Long userId) {
        Order order = new Order();

        order.setId(1L);
        //TODO: 远程查询商品信息
        order.setTotalAmount(new BigDecimal("0"));
        order.setUserId(userId);
        order.setNickName("lqq");
        order.setAddress("xian");
        //TODO: 远程查询商品列表
        order.setProductlist(null);

        return order;
    }
}
