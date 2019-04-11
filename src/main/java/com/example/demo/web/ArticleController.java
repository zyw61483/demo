package com.example.demo.web;

import com.example.demo.domain.dto.ArticleReq;
import com.example.demo.domain.entity.Article;
import com.example.demo.domain.enums.RoleEnum;
import com.example.demo.domain.dto.Result;
import com.example.demo.domain.entity.User;
import com.example.demo.service.ArticleService;
import com.example.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.Date;
import java.util.List;

@Slf4j
@RestController("article")
public class ArticleController {

	@Autowired
	private ArticleService articleService;

	@RequestMapping(value = "findByPage")
	public ResponseEntity findByPage (@RequestBody ArticleReq req){
		Page<Article> page = articleService.findByPage(req);
		return ResponseEntity.ok(page);
	}

}
