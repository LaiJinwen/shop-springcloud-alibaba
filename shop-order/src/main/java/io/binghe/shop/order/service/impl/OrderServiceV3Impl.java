package io.binghe.shop.order.service.impl;

import com.alibaba.fastjson.JSONObject;
import io.binghe.shop.bean.Order;
import io.binghe.shop.bean.OrderItem;
import io.binghe.shop.bean.Product;
import io.binghe.shop.bean.User;
import io.binghe.shop.order.OrderParams;
import io.binghe.shop.order.mapper.OrderItemMapper;
import io.binghe.shop.order.mapper.OrderMapper;
import io.binghe.shop.order.service.OrderService;
import io.binghe.shop.utils.constans.HttpCode;
import io.binghe.shop.utils.resp.Result;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;

@Slf4j
@Service("orderServiceV3")
public class OrderServiceV3Impl implements OrderService {

    private String userServer = "";
    private String productServer = "";

    @Autowired
    private DiscoveryClient discoveryClient;
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private OrderItemMapper orderItemMapper;
    @Autowired
    private RestTemplate restTemplate;

    @PostConstruct
    public void init() {
        this.userServer = this.getServiceUrl("server-user");
        this.productServer = this.getServiceUrl("server-product");
    }

    private String getServiceUrl(String serviceName){
        List<ServiceInstance> instLst = discoveryClient.getInstances(serviceName);
        if(instLst.isEmpty()){
            return serviceName + " not start";
        } else {
            int index = new Random().nextInt(instLst.size());
            ServiceInstance serviceInstance = instLst.get(index);
            String url = serviceInstance.getHost() + ":" + serviceInstance.getPort();
            log.info("负载均衡后的服务地址为:{}", url);
            return url;
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveOrder(OrderParams orderParams) {
        if (orderParams.isEmpty()){
            throw new RuntimeException("参数异常: " + JSONObject.toJSONString(orderParams));
        }
        this.init();//todo 测试负载均衡
        User user = restTemplate.getForObject("http://"+this.userServer+"/user/get/" + orderParams.getUserId(), User.class);
        if (user == null){
            throw new RuntimeException("未获取到用户信息: " + JSONObject.toJSONString(orderParams));
        }
        Product product = restTemplate.getForObject("http://"+this.productServer+"/product/get/" + orderParams.getProductId(), Product.class);
        if (product == null){
            throw new RuntimeException("未获取到商品信息: " + JSONObject.toJSONString(orderParams));
        }
        if (product.getProStock() < orderParams.getCount()){
            throw new RuntimeException("商品库存不足: " + JSONObject.toJSONString(orderParams));
        }
        Order order = new Order();
        order.setAddress(user.getAddress());
        order.setPhone(user.getPhone());
        order.setUserId(user.getId());
        order.setUsername(user.getUsername());
        order.setTotalPrice(product.getProPrice().multiply(BigDecimal.valueOf(orderParams.getCount())));
        orderMapper.insert(order);

        OrderItem orderItem = new OrderItem();
        orderItem.setNumber(orderParams.getCount());
        orderItem.setOrderId(order.getId());
        orderItem.setProId(product.getId());
        orderItem.setProName(product.getProName());
        orderItem.setProPrice(product.getProPrice());
        orderItemMapper.insert(orderItem);

        Result<Integer> result = restTemplate.getForObject("http://localhost:8070/product/update_count/" + orderParams.getProductId() + "/" + orderParams.getCount(), Result.class);
        if (result.getCode() != HttpCode.SUCCESS){
            throw new RuntimeException("库存扣减失败");
        }
        log.info("库存扣减成功");
    }

}
