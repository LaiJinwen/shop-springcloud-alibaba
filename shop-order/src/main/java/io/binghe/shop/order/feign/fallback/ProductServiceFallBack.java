package io.binghe.shop.order.feign.fallback;

import io.binghe.shop.bean.Product;
import io.binghe.shop.order.feign.service.ProductService;
import io.binghe.shop.utils.resp.Result;
import org.springframework.stereotype.Component;

@Component
public class ProductServiceFallBack implements ProductService {

    @Override
    public Product getProduct(Long pid) {
        Product product = new Product();
        product.setId(-1L);
        return product;
    }

    @Override
    public Result<Integer> updateCount(Long pid, Integer count) {
        Result<Integer> result = new Result<>(1001,"触发了容错逻辑",-1);
        return result;
    }
}
