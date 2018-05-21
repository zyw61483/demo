package com.example.demo.domain.entity;

import com.example.demo.domain.demo_enum.OriginEnum;
import com.example.demo.domain.demo_enum.RoleEnum;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

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
