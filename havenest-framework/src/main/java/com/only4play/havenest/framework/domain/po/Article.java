package com.only4play.havenest.framework.domain.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

/**
 * @TableName t_article
 */
@TableName(value = "t_article")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Article implements Serializable {
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
    /**
     * 文章id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 作者id
     */
    @TableField(value = "user_id")
    private Integer userId;
    /**
     * 分类id
     */
    @TableField(value = "category_id")
    private Integer categoryId;
    /**
     * 缩略图
     */
    @TableField(value = "article_cover")
    private String articleCover;
    /**
     * 文章标题
     */
    @TableField(value = "article_title")
    private String articleTitle;
    /**
     * 文章摘要
     */
    @TableField(value = "article_desc")
    private String articleDesc;
    /**
     * 文章内容
     */
    @TableField(value = "article_content")
    private String articleContent;
    /**
     * 类型 (1原创 2转载 3翻译)
     */
    @TableField(value = "article_type")
    private Integer articleType;
    /**
     * 是否置顶 (0否 1是）
     */
    @TableField(value = "is_top")
    private Integer isTop;
    /**
     * 是否删除 (0否 1是)
     */
    @TableField(value = "is_delete")
    private Integer isDelete;
    /**
     * 是否推荐 (0否 1是)
     */
    @TableField(value = "is_recommend")
    private Integer isRecommend;
    /**
     * 状态 (1公开 2私密 3评论可见)
     */
    @TableField(value = "status")
    private Integer status;
    /**
     * 发表时间
     */
    @TableField(value = "create_time")
    private Date createTime;
    /**
     * 更新时间
     */
    @TableField(value = "update_time")
    private Date updateTime;

    /**
     * 浏览量
     */
    @TableField(value = "view_count")
    private BigInteger viewCount;

    /**
     * 是否允许评论(0否 1是)
     */
    @TableField(value = "is_comment")
    private Integer isComment;

    @TableField(exist = false)
    private String categoryName;
}