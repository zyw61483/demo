package com.example.demo.domain.demo_enum;

import lombok.Data;

/**
 * @author zhaoyiwei 2018/5/17 20:01
 */
public enum ResCodeEnum {
    SUCCESS("0000","请求成功"),
    FAIL("9999","请求失败");

    private String code;
    private String msg;
    ResCodeEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getMsg(){
        return msg;
    }
}
