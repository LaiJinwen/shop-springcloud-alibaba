package io.binghe.shop.utils.resp;

import java.io.Serializable;

/**
 * @author binghe
 * @version 1.0.0
 * @description 返回的结果数据
 */

public class Result<T> implements Serializable {

    private static final long serialVersionUID = 1497405107265595284L;
    /**
     * 状态码
     */
    private Integer code;
    /**
     * 状态描述
     */
    private String codeMsg;
    /**
     *  返回的数据
     */
    private T data;

    public Result(Integer code, String codeMsg, T data) {
        this.code = code;
        this.codeMsg = codeMsg;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getCodeMsg() {
        return codeMsg;
    }

    public void setCodeMsg(String codeMsg) {
        this.codeMsg = codeMsg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}