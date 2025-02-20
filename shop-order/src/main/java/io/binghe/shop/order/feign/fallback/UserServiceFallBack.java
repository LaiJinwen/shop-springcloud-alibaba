package io.binghe.shop.order.feign.fallback;

import io.binghe.shop.bean.User;
import io.binghe.shop.order.feign.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class UserServiceFallBack implements UserService {

    @Override
    public User getUser(Long uid) {
        User user = new User();
        user.setId(-1L);
        return user;
    }

}
