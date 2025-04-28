package com.only4play.havenest.framework.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.only4play.havenest.framework.domain.po.Article;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author macbookair
 * @description 针对表【t_article】的数据库操作Mapper
 * @createDate 2025-04-28 11:43:32
 * @Entity com.only4play.havenest.framework.domain.po.Article
 */
@Mapper
public interface ArticleMapper extends BaseMapper<Article> {

}




