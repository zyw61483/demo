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
public class ShoppingCar {
    @Id
    @GeneratedValue
    private long id;
    private long user_id;
    private long product_id;
    private String product_count;

}
