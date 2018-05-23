package com.example.demo.util;

import org.springframework.beans.BeanUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;

/**
 * @author zhaoyiwei 2018/5/22 17:16
 */
public class BeanUtil extends BeanUtils {
    public static void copyPropertie(Object source, Object target) throws IllegalAccessException {
        ArrayList<String> list = new ArrayList<>();
        for (Field field : source.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            Object o = field.get(source);
            if(o==null){
                list.add(field.getName());
            }
        }
        BeanUtils.copyProperties(source,target,list.toArray(new String[list.size()]));
    }
}
