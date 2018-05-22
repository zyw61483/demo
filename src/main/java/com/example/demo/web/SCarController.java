package com.example.demo.web;

import com.example.demo.domain.dto.Result;
import com.example.demo.domain.entity.ShoppingCar;
import com.example.demo.domain.entity.User;
import com.example.demo.service.SCarService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class SCarController {

    @Autowired
    private SCarService sCarService;

    @RequestMapping(value = "scar/add", method = RequestMethod.POST)
    public ResponseEntity add(@RequestBody ShoppingCar car) {
        Result result = sCarService.addProductsforUser(car);
        return ResponseEntity.ok(result);
    }

    @RequestMapping(value = "scar/update", method = RequestMethod.POST)
    public ResponseEntity update(@RequestBody ShoppingCar car) {
        Result result = sCarService.updateProductforUser(car);
        return ResponseEntity.ok(result);
    }

}
