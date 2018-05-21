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
    private long user_id;
    private long product_id;
    private String product_count;

}
