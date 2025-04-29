package com.only4play.havenest.framework.mapper;

import com.only4play.havenest.framework.domain.po.Category;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author Administrator
* @description 针对表【t_category】的数据库操作Mapper
* @createDate 2025-04-28 19:30:42
* @Entity com.only4play.havenest.framework.domain.po.Category
*/
@Mapper
public interface CategoryMapper extends BaseMapper<Category> {

}




