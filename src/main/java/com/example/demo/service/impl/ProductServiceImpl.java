package com.example.demo.service.impl;

import com.example.demo.domain.demo_enum.ResCodeEnum;
import com.example.demo.domain.dto.Result;
import com.example.demo.domain.entity.Product;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ProductService;
import com.example.demo.util.GsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author zhaoyiwei 2018/5/10 14:55
 */
@Slf4j
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public ResponseEntity addProduct(Product product) {
        log.info("addProduct:{}",GsonUtil.toJson(product));
        Result result = new Result();
        try {
            result.setResCode(ResCodeEnum.SUCCESS);
            productRepository.save(product);
        }catch (Exception e){
            result.setResCode(ResCodeEnum.FAIL);
        }
        return ResponseEntity.ok().body(result);
    }

    @Override
    public ResponseEntity delProduct(Long productId) {
        Result result = new Result();
        try {
            result.setResCode(ResCodeEnum.SUCCESS);
            productRepository.deleteById(productId);
        }catch (Exception e){
            result.setResCode(ResCodeEnum.FAIL);
        }
        return ResponseEntity.ok().body(result);
    }

    @Override
    public ResponseEntity getProducts(Product product, Pageable pageable) {
        productRepository.findAll(new Specification<Product>() {
            @Override
            public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                ArrayList<Predicate> list = new ArrayList<>();
                if(!StringUtils.isEmpty(product.getName())){
                    list.add(cb.like(root.get("name"),"%"+product.getName()+"%"));
                }
                if(!StringUtils.isEmpty(product.getType())){
                    list.add(cb.like(root.get("type"),product.getType()));
                }
                return cb.and(list.toArray(new Predicate[list.size()]));
            }
        }, pageable);
        return null;
    }
}
