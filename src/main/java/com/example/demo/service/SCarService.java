package com.example.demo.service;

import com.example.demo.domain.dto.Result;
import com.example.demo.domain.entity.ShoppingCar;

/**
 * @author zhaoyiwei 2018/5/10 14:55
 */

public interface SCarService {
    Result addProductsforUser(ShoppingCar car);

    Result updateProductforUser(ShoppingCar car);
}
