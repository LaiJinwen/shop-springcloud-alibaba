package io.binghe.shop.order.feign.service;

import io.binghe.shop.bean.Product;
import io.binghe.shop.order.feign.fallback.ProductServiceFallBack;
import io.binghe.shop.utils.resp.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "server-product", fallback = ProductServiceFallBack.class)
public interface ProductService {
    /**
     * 获取商品信息
     */
    @GetMapping(value = "/product/get/{pid}")
    Product getProduct(@PathVariable("pid") Long pid);

    /**
     * 更新库存数量
     */
    @GetMapping(value = "/product/update_count/{pid}/{count}")
    Result<Integer> updateCount(@PathVariable("pid") Long pid,@PathVariable("count") Integer count);
}
