package com.example.demo.domain.entity;

import com.example.demo.domain.demo_enum.OrderStatus;
import lombok.Data;

import javax.persistence.*;
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
    private OrderStatus status;

}
