package com.only4play.havenest.framework.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryListVo {
    /**
     * 分类id
     */
    private Integer id;

    /**
     * 分类名
     */
    private String categoryName;
}
