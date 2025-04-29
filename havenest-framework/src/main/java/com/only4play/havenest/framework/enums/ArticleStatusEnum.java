package com.only4play.havenest.framework.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 文章状态枚举
 *
 * @author ican
 */
@Getter
@AllArgsConstructor
public enum ArticleStatusEnum {

    /**
     * 公开
     */
    PUBLIC(1, "公开"),

    /**
     * 私密
     */
    SECRET(2, "私密"),

    /**
     * 草稿
     */
    DRAFT(3, "草稿"),

    NOT_DELETED(0, "未删除");

    /**
     * 状态
     */
    private final Integer status;

    /**
     * 描述
     */
    private final String description;
}