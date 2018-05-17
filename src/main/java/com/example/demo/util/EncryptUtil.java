package com.example.demo.util;

import java.util.Base64;

/**
 * @author zhaoyiwei 2018/5/17 19:43
 */
public class EncryptUtil {
    public static final String KEY = "KEY";
    public static String getEncString(String content,String key){
        StringBuffer sb = new StringBuffer(content).append(key);
        return Base64.getEncoder().encodeToString(sb.toString().getBytes());
    }
}
