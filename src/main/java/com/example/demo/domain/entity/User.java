package com.example.demo.domain.entity;

import com.example.demo.domain.enums.OriginEnum;
import com.example.demo.domain.enums.RoleEnum;
import lombok.Data;

import javax.persistence.Entity;

/**
 * @author zhaoyiwei 2018/5/10 14:45
 */
@Data
@Entity
public class User extends BaseEntity {
    private String openId;
    private OriginEnum origin;
    private String name;
    private String pwd;
    private String phone;
    private RoleEnum role;
    private String province;
    private String city;
    private String address;

}
