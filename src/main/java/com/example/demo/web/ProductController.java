package com.example.demo.web;

import com.example.demo.domain.dto.Result;
import com.example.demo.domain.entity.Product;
import com.example.demo.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@RestController
public class ProductController {

	@Autowired
	private ProductService productService;

    @RequestMapping(value = "product/getProducts", method = RequestMethod.POST)
    public ResponseEntity getProducts (@RequestBody Product product){
        return productService.getProducts(product,PageRequest.of(product.getPageNo(), Result.PAGECOUNT, new Sort(Sort.Direction.DESC)));
    }

	@RequestMapping(value = "product/addProduct", method = RequestMethod.POST)
	public ResponseEntity addProduct (@RequestBody Product product){
		return productService.addProduct(product);
    }

    @RequestMapping(value = "product/delProduct", method = RequestMethod.POST)
    public ResponseEntity delProduct (Long productId){
        return productService.delProduct(productId);
    }

}
