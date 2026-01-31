package com.atguigu.order.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class TokenRequestInterceptor implements RequestInterceptor {

    /**
     * 拦截请求，给请求头添加token
     * requestTemplate:表示这次请求的详细信息封装到了RequestTemplate请求模板里
     * @param requestTemplate 请求模板
     */
    @Override
    public void apply(RequestTemplate requestTemplate) {
        System.out.println("拦截请求，给请求头添加token");
        requestTemplate.header("token", UUID.randomUUID().toString());

    }
}
