package io.binghe.shop.utils.passwd;

import io.binghe.shop.utils.md5.MD5Hash;

public class PasswordUtils {

    public  static String getPassowrd(String passwd){
        return MD5Hash.hash(passwd);
    }

}
