package io.binghe.shop.product;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement(proxyTargetClass = true)
@MapperScan(value = { "io.binghe.shop.product.mapper" })
@EnableDiscoveryClient
public class ProductStarter {
    public static void main(String[] args) {
        SpringApplication.run(ProductStarter.class,args);
    }
}
