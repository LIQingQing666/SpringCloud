package com.atguigu.product.bean;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Data
@Component
public class Product {
    private Long id;
    private BigDecimal price;
    private String productname;
    private int num;
}
