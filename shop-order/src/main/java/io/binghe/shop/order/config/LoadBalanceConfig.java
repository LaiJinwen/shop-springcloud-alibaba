package io.binghe.shop.order.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author binghe
 * @version 1.0.0
 * @description 配置类
 */
@Configuration
public class LoadBalanceConfig {

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}