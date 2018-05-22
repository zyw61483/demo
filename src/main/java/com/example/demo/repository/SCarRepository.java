package com.example.demo.repository;

import com.example.demo.domain.entity.ShoppingCar;
import com.example.demo.domain.entity.User;
import org.springframework.data.repository.CrudRepository;

/**
 * @author zhaoyiwei 2018/5/10 15:38
 */
public interface SCarRepository extends CrudRepository<ShoppingCar, Long> {
    ShoppingCar findByUserIdAndProductId(long userId,long productId);
}
