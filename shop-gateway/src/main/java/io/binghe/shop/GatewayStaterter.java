package io.binghe.shop;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement(proxyTargetClass = true)
@MapperScan(value = {"io.binghe.shop.gateway"})
@EnableDiscoveryClient
public class GatewayStaterter {
    public static void main(String[] args) {
        SpringApplication.run(GatewayStaterter.class,args);
    }
}
