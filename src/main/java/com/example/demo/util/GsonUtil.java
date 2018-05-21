package com.example.demo.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.extern.slf4j.Slf4j;

import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;

/**
 * @author zhaoyiwei 2018/5/21 15:34
 */
@Slf4j
public class GsonUtil {
    private static final String EMPTY_JSON           = "{}";
    private static final String EMPTY_JSON_ARRAY     = "[]";
    private static final String DEFAULT_DATE_PATTERN = "yyyy-MM-dd HH:mm:ss";

    public static String toJson(Object target) {
        if (target == null) {
            return EMPTY_JSON;
        }
        GsonBuilder builder = new GsonBuilder();
        builder.setDateFormat(DEFAULT_DATE_PATTERN);

        Gson gson = builder.create();
        String result = EMPTY_JSON;
        try {
                result = gson.toJson(target);
        } catch (Exception ex) {
            log.warn("目标对象转换为json异常 errMessage{}", ex.getMessage(), ex);
            if (target instanceof Collection<?> || target instanceof Iterator<?> || target instanceof Enumeration<?>
                    || target.getClass().isArray()) {
                result = EMPTY_JSON_ARRAY;
            }
        }
        return result;
    }
}
