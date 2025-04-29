package com.only4play.havenest.framework.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HotArticleVo {
    private Integer id;
    //标题
    private String articleTitle;
    //访问量
    private BigInteger viewCount;
}