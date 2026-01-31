package com.atguigu.order.controller;

import com.atguigu.order.bean.Order;
import com.atguigu.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope//导入配置中心时，自动刷新配置
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Value("${order.timeout}")
    String orderTimeout ;
    @Value("${order.auto-confirm}")
    String orderAutoConfirm;

    /**
     * 返回获取配置的值
     * @return
     */
    @GetMapping("/config")
    public String config(){
        return "order.timeout:" + orderTimeout + " order.auto-confirm:" + orderAutoConfirm;
    }
    /**
     * 创建订单
     */
    @GetMapping("/create")
    public Order createOrder(@RequestParam("productId") Long productId,
                            @RequestParam("userId") Long userId) {
        Order order = orderService.createOrder(productId, userId);
        return order;
    }
}
