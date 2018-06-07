package com.example.demo.service.impl;

import com.example.demo.domain.enums.ResCodeEnum;
import com.example.demo.domain.dto.Result;
import com.example.demo.domain.entity.ShoppingCar;
import com.example.demo.repository.SCarRepository;
import com.example.demo.service.SCarService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhaoyiwei 2018/5/10 14:55
 */
@Slf4j
@Service
public class SCarServiceImpl implements SCarService {

    @Autowired
    private SCarRepository sCarRepository;


    @Override
    public Result addProductsforUser(ShoppingCar car) {
        Result result = new Result();
        try {
            sCarRepository.save(car);
            result.setResCode(ResCodeEnum.SUCCESS);
        }catch (Exception e){
            log.error("加入购物车失败 userid={} productid={}",car.getUserId(),car.getProductId(),e);
            result.setResCode(ResCodeEnum.FAIL);
        }
        return result;
    }

    @Override
    public Result updateProductforUser(ShoppingCar car) {
        Result result = new Result();
        try{
            ShoppingCar sc = sCarRepository.findByUserIdAndProductId(car.getUserId(), car.getProductId());
            if(car.getProductCount()!=0) {
                sc.setProductCount(car.getProductCount());
                sCarRepository.save(sc);
            }else{
                sCarRepository.delete(sc);
            }
            result.setResCode(ResCodeEnum.SUCCESS);
        }catch (Exception e){
            result.setResCode(ResCodeEnum.FAIL);
        }
        return result;
    }
}
