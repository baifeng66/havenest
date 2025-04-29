package com.only4play.havenest.framework.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.only4play.havenest.framework.domain.po.Article;
import com.only4play.havenest.framework.domain.vo.ArticleListVo;
import com.only4play.havenest.framework.domain.vo.HotArticleVo;
import com.only4play.havenest.framework.domain.vo.PageVo;
import com.only4play.havenest.framework.enums.ArticleStatusEnum;
import com.only4play.havenest.framework.mapper.ArticleMapper;
import com.only4play.havenest.framework.result.ResponseResult;
import com.only4play.havenest.framework.service.ArticleService;
import com.only4play.havenest.framework.service.CategoryService;
import com.only4play.havenest.framework.utils.BeanCopyUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
* @author macbookair
* @description 针对表【t_article】的数据库操作Service实现
* @createDate 2025-04-28 11:43:32
*/
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService{

    @Resource
    private CategoryService categoryService;

    @Override
    public ResponseResult<List<HotArticleVo>> hotArticleList() {
        // 配置查询条件（文章状态为公开，未删除，排序按照浏览量倒序）
        LambdaQueryWrapper<Article> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Article::getStatus, ArticleStatusEnum.PUBLIC.getStatus());
        queryWrapper.eq(Article::getIsDelete, ArticleStatusEnum.NOT_DELETED.getStatus());
        queryWrapper.orderByDesc(Article::getViewCount);
        // 限制10条数据
        queryWrapper.last("LIMIT 10");
        List<Article> articleList = this.list(queryWrapper);
        //bean拷贝
        List<HotArticleVo> articleVos = new ArrayList<>();
        // 转换为vos
        for (Article article : articleList) {
            HotArticleVo hotArticleVo = new HotArticleVo();
            BeanUtils.copyProperties(article, hotArticleVo);
            articleVos.add(hotArticleVo);
        }
        return ResponseResult.okResult(articleVos);
    }

    @Override
    public List<Integer> getCategoryIdList() {
        LambdaQueryWrapper<Article> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Article::getStatus, ArticleStatusEnum.PUBLIC.getStatus());
        queryWrapper.eq(Article::getIsDelete, ArticleStatusEnum.NOT_DELETED.getStatus());
        return list(queryWrapper).stream().map(Article::getCategoryId).distinct().collect(Collectors.toList());
    }

    @Override
    public ResponseResult articleList(Integer categoryId, Integer pageNum, Integer pageSize) {
        // 参数校验
        if(pageNum == null || pageNum < 1){
            pageNum = 1;
        }
        if(pageSize == null || pageSize < 1){
            pageSize = 10;
        }
        // 配置查询条件（文章状态为公开，未删除，分类ID为categoryId，排序按照创建时间倒序）
        LambdaQueryWrapper<Article> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Article::getStatus, ArticleStatusEnum.PUBLIC.getStatus());
        queryWrapper.eq(Article::getIsDelete, ArticleStatusEnum.NOT_DELETED.getStatus());
        // 分类ID不为空时，添加条件
        queryWrapper.eq(ObjectUtils.isNotEmpty(categoryId) && categoryId > 0 ,Article::getCategoryId, categoryId);
        // 排序条件
        queryWrapper.orderByDesc(Article::getIsTop, Article::getCreateTime);
        // 分页查询
        Page<Article> page = new Page<>(pageNum, pageSize);
        IPage<Article> iPage = this.page(page, queryWrapper);
        // 转换为vos
        List<Article> articleList = iPage.getRecords();
        // 使用stream流设置分类名称
        //todo 分表查询
//        articleList.forEach(article -> {article.setCategoryName(categoryService.getById(article.getCategoryId()).getCategoryName());});
        articleList =  articleList.stream().map(article -> {
            article.setCategoryName(categoryService.getById(article.getCategoryId()).getCategoryName());
            return article;
        }).collect(Collectors.toList());
        List<ArticleListVo> articleVos = BeanCopyUtils.copyBeanList(articleList, ArticleListVo.class);
        // 返回结果
        PageVo<ArticleListVo> pageVo = new PageVo<>();
        pageVo.setRows(articleVos);
        pageVo.setTotal(iPage.getTotal());
        return ResponseResult.okResult(pageVo);
    }
}




