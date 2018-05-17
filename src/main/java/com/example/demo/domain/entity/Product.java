package com.example.demo.domain.entity;

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
public class Product {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String type;
    private String count;
    private String price;
    private String des;
    private Date creatTime;


}
