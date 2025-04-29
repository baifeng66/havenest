package com.only4play.havenest.framework.service;

import com.only4play.havenest.framework.domain.po.Category;
import com.baomidou.mybatisplus.extension.service.IService;
import com.only4play.havenest.framework.domain.vo.CategoryListVo;
import com.only4play.havenest.framework.result.ResponseResult;

import java.util.List;

/**
* @author Administrator
* @description 针对表【t_category】的数据库操作Service
* @createDate 2025-04-28 19:30:42
*/
public interface CategoryService extends IService<Category> {

    // 获取所有分类列表
    ResponseResult<List<CategoryListVo>> getCategoryList();
}
