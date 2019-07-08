package com.example.demo.domain.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author zhaoyiwei 2018/12/21 17:56
 */
@Data
@Entity
@Table(name = "token")
public class Token extends BaseEntity {
    @Column(columnDefinition="int(16) COMMENT '用户唯一标识'")
    private long user_id;
    @Column(columnDefinition="varchar(32) COMMENT '用户token'")
    private long token;

}
