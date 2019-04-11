package com.example.demo.service.impl;

import com.example.demo.domain.dto.ArticleReq;
import com.example.demo.domain.dto.Result;
import com.example.demo.domain.entity.Article;
import com.example.demo.domain.entity.User;
import com.example.demo.domain.enums.ResCodeEnum;
import com.example.demo.repository.ArticleRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.ArticleService;
import com.example.demo.service.UserService;
import com.example.demo.util.EncryptUtil;
import com.example.demo.util.GsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhaoyiwei 2018/5/10 14:55
 */
@Slf4j
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleRepository articleRepository;


    @Override
    public Page<Article> findByPage(ArticleReq req)
    {
        Pageable pageable = PageRequest.of(req.getPageNo(),req.getPageSize(),Sort.Direction.DESC,"createdTime");
        Page<Article> all = articleRepository.findAll(pageable);
        List<Article> content = all.getContent();
        log.info("findByPage {}",GsonUtil.toJson(content));
        return all;
    }
}
