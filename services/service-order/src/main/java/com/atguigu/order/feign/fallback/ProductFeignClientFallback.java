package com.atguigu.order.feign.fallback;
import java.math.BigDecimal;

import com.atguigu.order.feign.ProductFeignClient;
import com.atguigu.product.bean.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductFeignClientFallback implements ProductFeignClient {
    @Override
    public Product getProductById(Long productId) {
        /**
         * 只有远程服务调用失败，才会进入此方法
         */
        System.out.println("进入兜底回调...");
        Product product = new Product();
        product.setId(productId);
        product.setPrice(new BigDecimal("0"));
        product.setProductname("未知商品");
        product.setNum(0);

        return product;
    }
}
