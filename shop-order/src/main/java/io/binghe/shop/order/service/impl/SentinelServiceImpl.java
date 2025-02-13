package io.binghe.shop.order.service.impl;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import io.binghe.shop.order.service.SentinelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SentinelServiceImpl implements SentinelService {

    @Override
    @SentinelResource("sendMessage")
    public void sendMessage() {

    }
}
