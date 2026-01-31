package com.atguigu.order.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value="weather-client", url = "https://restapi.amap.com")
public interface WeatherFeignClient {

    /**
     * 获取天气信息
     * @return
     */
    @GetMapping("/v3/weather/weatherInfo")
    String getRealTimeWeather(
            @RequestParam("city") String city,
            @RequestParam("key") String key,
            @RequestParam(value = "extensions", defaultValue = "base") String extensions
    );
}
