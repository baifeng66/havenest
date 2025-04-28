package com.only4play.havenest.blog.controller;

import com.only4play.havenest.framework.domain.po.Article;
import com.only4play.havenest.framework.service.ArticleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/***
 *@title ArticleController
 *@description <TODO description class purpose>
 *@author macbookair
 *@version 1.0.0
 *@create 2025/4/28 12:45
 **/
@RestController
@RequestMapping("article")
public class ArticleController {
    @Resource
    private ArticleService articleService;

    @GetMapping("/list")
    public List<Article> list() {
        return articleService.list();
    }
}
