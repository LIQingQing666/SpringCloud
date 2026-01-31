package com.atguigu.order.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Data
@ConfigurationProperties(prefix = "order")//配置批量绑定在nacos下，可以无需@RefreshScope就可实现
public class OrderProperties {
    String Timeout ;
    String AutoConfirm;
    String dbUrl;
}
