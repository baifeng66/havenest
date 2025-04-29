package com.only4play.havenest.framework.service;

import com.only4play.havenest.framework.domain.po.Article;
import com.baomidou.mybatisplus.extension.service.IService;
import com.only4play.havenest.framework.domain.vo.HotArticleVo;
import com.only4play.havenest.framework.result.ResponseResult;

import java.util.List;

/**
* @author macbookair
* @description 针对表【t_article】的数据库操作Service
* @createDate 2025-04-28 11:43:32
*/
public interface ArticleService extends IService<Article> {

    /**
     * 获取热门文章列表
     * @return
     */
    ResponseResult<List<HotArticleVo>> hotArticleList();

    List<Integer> getCategoryIdList();


    ResponseResult articleList(Integer categoryId, Integer pageNum, Integer pageSize);
}
