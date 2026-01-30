package com.atguigu.order.service.impl;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import com.atguigu.order.bean.Order;
import com.atguigu.order.service.OrderService;
import com.atguigu.product.bean.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Autowired
    DiscoveryClient discoveryClient;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired//一定导入spring-cloud-starter-loadbalancer
    LoadBalancerClient loadBalancerClient;

    /**
     * 创建订单,并远程调用商品服务查询商品信息
     * @param productId
     * @param userId
     * @return
     */
    @Override
    public Order createOrder(Long productId, Long userId) {
        Order order = new Order();
        Product product = getProductFromRemoteWithLoadBalancer(productId);
        order.setId(1L);
        //总金额
        order.setTotalAmount(product.getPrice().multiply(new BigDecimal(product.getNum())));
        order.setUserId(userId);
        order.setNickName("lqq");
        order.setAddress("xian");
        //商品列表
        order.setProductlist(Arrays.asList( product));

        return order;
    }

    /**
     * 根据商品信息远程调用商品服务-无负载均衡
     * @param productId
     * @return
     */
    private Product getProductFromRemote(Long productId) {
        //1.获取到商品服务所在的所有机器ip+port
        List<ServiceInstance> instances = discoveryClient.getInstances("service-product");
        //在list中随机取一个ip+port，这里获取第一个实例
        ServiceInstance instance = instances.get(0);
        //远程url
         String url = "http://" +instance.getHost() + ":" + instance.getPort() + "/product/" + productId;
         //2.给远程发送请求
        log.info("远程请求，路径是url:{}",url);
        Product forObject = restTemplate.getForObject(url, Product.class);
        return forObject;
    }

    /**
     * 进阶：根据商品信息远程调用商品服务-负载均衡
     * @param productId
     * @return
     */
    private Product getProductFromRemoteWithLoadBalancer(Long productId) {
        //1.获取到商品服务所在的所有机器ip+port
        ServiceInstance choose = loadBalancerClient.choose("service-product");
        //远程url
        String url = "http://" +choose.getHost() + ":" + choose.getPort() + "/product/" + productId;
        //2.给远程发送请求
        log.info("远程请求，路径是url:{}",url);
        Product forObject = restTemplate.getForObject(url, Product.class);
        return forObject;
    }
}
