package com.example.demo.util;

import org.springframework.beans.BeanUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author zhaoyiwei 2018/5/22 17:16
 */
public class BeanUtil extends BeanUtils {
    public static void copyPropertie(Object source, Object target) throws IllegalAccessException {
        ArrayList<String> list = new ArrayList<>();
        Field[] subFields = source.getClass().getDeclaredFields();
        Field[] supFields = source.getClass().getSuperclass().getDeclaredFields();
        List<Field> fields = Arrays.asList(subFields);
        fields.addAll(Arrays.asList(supFields));
        for (Field field : fields) {
            addIgnoreField(source, list, field);
        }
        BeanUtils.copyProperties(source, target, list.toArray(new String[list.size()]));
    }

    private static void addIgnoreField(Object source, ArrayList<String> list, Field field) throws IllegalAccessException {
        field.setAccessible(true);
        Object o = field.get(source);
        if (o == null) {
            list.add(field.getName());
        }
    }
}
