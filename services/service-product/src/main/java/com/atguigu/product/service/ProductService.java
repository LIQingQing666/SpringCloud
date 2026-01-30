package com.atguigu.product.service;

import com.atguigu.product.bean.Product;

public interface    ProductService {

    /**
     * 根据id查询商品信息
     * @param productId
     * @return
     */
    Product getProduct(Long productId);
}
