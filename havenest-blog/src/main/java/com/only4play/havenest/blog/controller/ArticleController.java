package com.only4play.havenest.blog.controller;

import com.only4play.havenest.framework.domain.vo.HotArticleVo;
import com.only4play.havenest.framework.result.ResponseResult;
import com.only4play.havenest.framework.service.ArticleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
@RequestMapping("/article")
public class ArticleController {
    @Resource
    private ArticleService articleService;

    /**
     * 获取热门文章列表(前 10 篇)
     * @return
     */
    @GetMapping("/hotArticleList")
    public ResponseResult<List<HotArticleVo>> hotArticleList() {
        return articleService.hotArticleList();
    }

    /**
     * 获取文章列表
     * @param categoryId
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/articleList")
    public ResponseResult articleList(@RequestParam(required = false) Integer categoryId,
                                      @RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        return articleService.articleList(categoryId, pageNum, pageSize);
    }
}
