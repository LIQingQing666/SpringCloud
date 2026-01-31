package com.atguigu.order;

import com.atguigu.order.feign.WeatherFeignClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class WeatherTest {

    @Autowired
    WeatherFeignClient weatherFeignClient;

    @Test
    void test(){
        // 替换为你的高德 key + 城市编码（例如北京：110000）
        String key = "te2a41e0b7c6928a2d51f188627b5ac37";
        String city = "110000";

        try {
            String result = weatherFeignClient.getRealTimeWeather(city, key, "base");
            System.out.println("高德天气接口返回：" + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
