package com.only4play.havenest.framework.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleListVo {
    private Integer id;
    private String articleTitle;
    private BigInteger viewCount;
    private String categoryName;
    private Date createTime;
    private String articleDesc;
    private String articleCover;
}
