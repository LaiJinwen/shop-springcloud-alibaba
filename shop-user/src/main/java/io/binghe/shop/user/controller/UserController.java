package io.binghe.shop.user.controller;

import com.alibaba.fastjson.JSONObject;
import io.binghe.shop.bean.User;
import io.binghe.shop.user.service.UserService;
import io.binghe.shop.utils.exceptions.RestCtrlExceptionHandler;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author binghe
 * @version 1.0.0
 * @description 用户接口
 */
@RestController
public class UserController {
//    private final Logger log = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    @GetMapping(value = "/get/{uid}")
    public User getUser(@PathVariable("uid") Long uid){
        User user = userService.getUserById(uid);
//        log.info("获取到的用户信息为：{}", JSONObject.toJSONString(user));
        return user;
    }
}