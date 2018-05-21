package com.example.demo.domain.entity;

import com.example.demo.domain.demo_enum.OrderStatusEnum;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author zhaoyiwei 2018/5/10 14:45
 */
@Data
@Entity
@Table(name = "iorder")
public class Order extends BaseEntity {
    private long user_id;
    private long product_id;
    private String product_count;
    private OrderStatusEnum status;

}
