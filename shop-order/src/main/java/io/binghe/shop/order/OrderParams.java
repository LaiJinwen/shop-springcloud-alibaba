package io.binghe.shop.order;


import org.apache.commons.lang3.StringUtils;

public class OrderParams {
    private Integer count;
    private String price;
    private String userId;
    private String productId;

    public boolean isEmpty(){
        return StringUtils.isAllEmpty(String.valueOf(this.count), this.productId, this.price, this.userId);
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
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
