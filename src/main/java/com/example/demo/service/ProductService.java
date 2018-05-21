package com.example.demo.service;

import com.example.demo.domain.entity.Product;
import org.springframework.http.ResponseEntity;

/**
 * @author zhaoyiwei 2018/5/21 15:18
 */
public interface ProductService {
    ResponseEntity addProduct(Product product);

    ResponseEntity delProduct(Long productId);
}
