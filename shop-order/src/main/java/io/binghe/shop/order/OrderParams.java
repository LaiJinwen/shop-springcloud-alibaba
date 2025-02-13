package io.binghe.shop.order;


import org.apache.commons.lang3.StringUtils;

public class OrderParams {
    private Integer count;
    private String price;
    private Long userId;
    private Long productId;

    public boolean isEmpty(){
        return StringUtils.isAllEmpty(String.valueOf(this.count), String.valueOf(this.productId), this.price, String.valueOf(this.userId));
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
