package com.atguigu.order.feign;

import com.atguigu.product.bean.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(value = "service-product")
//声明这个类是一个FeignClient,value值表示要远程调用微服务的名字
public interface ProductFeignClient {

    //MVC注解的两套使用逻辑：
    //1.标注在Controller上，表示接收这样的请求
    //2.标注在FeignClient上，表示发送这样的请求
    @GetMapping("/product/{productId}")
    Product getProductById(@PathVariable("productId") Long productId);
}
