package com.example.demo.domain.entity;

import com.example.demo.domain.demo_enum.Role;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author zhaoyiwei 2018/5/10 14:45
 */
@Data
@Entity
public class User {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String phone;
    private Date creatTime;
    private Role role;
    private String province;
    private String city;
    private String address;

}
