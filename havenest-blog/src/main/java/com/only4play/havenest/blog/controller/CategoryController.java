package com.only4play.havenest.blog.controller;

import com.only4play.havenest.framework.domain.vo.CategoryListVo;
import com.only4play.havenest.framework.result.ResponseResult;
import com.only4play.havenest.framework.service.CategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Resource
    private CategoryService categoryService;

    /**
     * 获取所有分类列表
     * @return
     */
    @GetMapping("/getCategoryList")
    public ResponseResult<List<CategoryListVo>> getCategoryList() {
        return categoryService.getCategoryList();
    }
}
