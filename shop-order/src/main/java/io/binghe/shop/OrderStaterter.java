package io.binghe.shop;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement(proxyTargetClass = true)
@MapperScan(value = {"io.binghe.shop.order.mapper"})
@EnableDiscoveryClient
@EnableFeignClients
public class OrderStaterter {
    public static void main(String[] args) {
        SpringApplication.run(OrderStaterter.class,args);
    }
}
