package com.example.demo.service;

import com.example.demo.domain.dto.ArticleReq;
import com.example.demo.domain.entity.Article;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @author zhaoyiwei 2018/5/10 14:55
 */

public interface ArticleService {

    Page<Article> findByPage(ArticleReq req);
}