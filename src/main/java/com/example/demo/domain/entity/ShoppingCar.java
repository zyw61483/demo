package com.example.demo.domain.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author zhaoyiwei 2018/5/10 14:45
 */
@Data
@Entity
public class ShoppingCar extends BaseEntity {
    private long userId;
    private long productId;
    private int productCount;

}
