package com.example.demo.domain.enums;

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
