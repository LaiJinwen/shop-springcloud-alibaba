package io.binghe.shop.order.controller;

import com.alibaba.fastjson.JSONObject;
import io.binghe.shop.order.OrderParams;
import io.binghe.shop.order.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class OrderController {

    @Autowired
    @Qualifier("orderServiceV5")
    private OrderService orderService;

    @GetMapping(value = "/submit_order")
    public String submitOrder(OrderParams orderParams) {
        //http://localhost:8080/order/submit_order?productId=1001&userId=1001&count=1
        log.info("提交订单时传递的参数:{}", JSONObject.toJSONString(orderParams));
        orderService.saveOrder(orderParams);
        return "success";
    }

    @GetMapping(value = "/test_sentinel")
    public String testSentinel() {
        log.info("testSentinel:{}");
        return "success";
    }

}