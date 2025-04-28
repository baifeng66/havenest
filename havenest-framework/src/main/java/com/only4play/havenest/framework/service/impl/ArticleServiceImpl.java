package com.only4play.havenest.framework.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.only4play.havenest.framework.domain.po.Article;
import com.only4play.havenest.framework.service.ArticleService;
import com.only4play.havenest.framework.mapper.ArticleMapper;
import org.springframework.stereotype.Service;

/**
* @author macbookair
* @description 针对表【t_article】的数据库操作Service实现
* @createDate 2025-04-28 11:43:32
*/
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article>
    implements ArticleService{

}




