package io.binghe.shop.order.feign.service;

import io.binghe.shop.bean.User;
import io.binghe.shop.order.feign.fallback.UserServiceFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "server-user", fallback = UserServiceFallBack.class)
public interface UserService {

    @GetMapping(value="/user/get/{uid}")
    User getUser(@PathVariable("uid") Long uid);

}
