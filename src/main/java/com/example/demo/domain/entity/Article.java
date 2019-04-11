package com.example.demo.domain.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author zhaoyiwei 2018/5/10 14:45
 */
@Data
@Entity
@Table(name = "article")
public class Article extends BaseEntity {
    private String bookName;
    private String chapter;
    private String content;
    private String author;
}
