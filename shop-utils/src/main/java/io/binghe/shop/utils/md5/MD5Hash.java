package io.binghe.shop.utils.md5;

import cn.hutool.crypto.SecureUtil;

public class MD5Hash {

    public static String hash(String param){
        return  SecureUtil.md5(param);
    }
}
