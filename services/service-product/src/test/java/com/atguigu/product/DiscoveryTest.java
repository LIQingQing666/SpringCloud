package com.atguigu.product;

import com.alibaba.cloud.nacos.discovery.NacosServiceDiscovery;
import com.alibaba.nacos.api.exception.NacosException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;

import java.util.List;

@SpringBootTest
public class DiscoveryTest {

    @Autowired
    DiscoveryClient discoveryClient;

    @Autowired
    NacosServiceDiscovery nacosServiceDiscovery;

    @Test
    void discoveryClientTest() {
        //获取所有微服务名称和微服务IP和端口
        for (String service : discoveryClient.getServices()) {
            System.out.println(service);
            //获取ip + port，获取实例
            List<ServiceInstance> instances = discoveryClient.getInstances(service);
            for (ServiceInstance instance : instances) {
                System.out.println("ip:" + instance.getHost() + ";" + "port:" + instance.getPort());
            }
        }
    }

    @Test
    void nacosServiceDiscoveryTest() throws NacosException {
        //获取所有微服务名称和微服务IP和端口
        for (String service : nacosServiceDiscovery.getServices()) {
            System.out.println(service);
            //获取ip + port，获取实例
            List<ServiceInstance> instances = nacosServiceDiscovery.getInstances(service);
            for (ServiceInstance instance : instances) {
                System.out.println("ip:" + instance.getHost() + ";" + "port:" + instance.getPort());
            }
        }
    }
}
