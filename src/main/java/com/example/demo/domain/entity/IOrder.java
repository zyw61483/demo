package com.example.demo.domain.entity;

import com.example.demo.domain.demo_enum.OrderStatusEnum;
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
public class IOrder {
    @Id
    @GeneratedValue
    private long id;
    private long user_id;
    private long product_id;
    private Date creatTime;
    private String product_count;
    private OrderStatusEnum status;

}
