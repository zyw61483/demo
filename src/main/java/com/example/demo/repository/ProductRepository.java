package com.example.demo.repository;

import com.example.demo.domain.entity.Product;
import org.springframework.data.repository.CrudRepository;

/**
 * @author zhaoyiwei 2018/5/21 15:20
 */
public interface ProductRepository extends CrudRepository<Product, Long> {
}
