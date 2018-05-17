package com.example.demo.domain.dto;

import com.example.demo.domain.demo_enum.ResCodeEnum;
import lombok.Data;

/**
 * @author zhaoyiwei 2018/5/17 19:54
 */
@Data
public class Result {
    private ResCodeEnum ResCode;
    private String ResMsg;
}
