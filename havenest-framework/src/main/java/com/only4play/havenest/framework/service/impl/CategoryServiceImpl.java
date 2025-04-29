package com.only4play.havenest.framework.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.only4play.havenest.framework.domain.po.Category;
import com.only4play.havenest.framework.domain.vo.CategoryListVo;
import com.only4play.havenest.framework.mapper.CategoryMapper;
import com.only4play.havenest.framework.result.ResponseResult;
import com.only4play.havenest.framework.service.ArticleService;
import com.only4play.havenest.framework.service.CategoryService;
import com.only4play.havenest.framework.utils.BeanCopyUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
* @author Administrator
* @description 针对表【t_category】的数据库操作Service实现
* @createDate 2025-04-28 19:30:42
*/
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService{
    @Resource
    private ArticleService articleService;
    // 获取所有分类列表
    @Override
    public ResponseResult<List<CategoryListVo>> getCategoryList() {
        // 1. 查询文章表里面的分类id
        List<Integer> categoryIdList = articleService.getCategoryIdList();
        // 2. 查询分类表里面的分类信息
        List<Category> categories = listByIds(categoryIdList);
        // 2.1 过滤掉禁用的分类
        categories =categories.stream().filter(category -> category.getStatus() == 0 && category.getIsDelete() == 0).collect(Collectors.toList());
        // 3. 复制分类信息到vo对象
        List<CategoryListVo> categoryVos = BeanCopyUtils.copyBeanList(categories, CategoryListVo.class);
        return ResponseResult.okResult(categoryVos);
    }
}




