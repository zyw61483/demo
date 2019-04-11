package com.example.demo.repository;

import com.example.demo.domain.entity.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

/**
 * @author zhaoyiwei 2018/5/10 15:38
 */
public interface ArticleRepository extends CrudRepository<Article, Long> {
    Page<Article> findAll(Pageable pageable);
}
