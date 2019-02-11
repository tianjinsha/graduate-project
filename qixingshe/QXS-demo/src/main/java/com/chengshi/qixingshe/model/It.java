package com.chengshi.qixingshe.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @author ${author}
 * @since 2018-12-10
 */
@Data
@TableName("it")
public class It extends Model<It> {

    private static final long serialVersionUID = 1L;

    /**
     * IT文章ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 文章标题
     */
    private String title;
    /**
     * 文章作者
     */
    private String author;
    /**
     * 文章内容
     */
    private String content;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 阅读数量
     */
    private Integer readingCount;
    /**
     * 分类ID
     */
    private Integer itCategoryId;
    /**
     * 用户ID
     */
    private Integer userId;

    /**
     * 状态
     */
    private String status;

    private ItCategory itCategory;

    private User user;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "It{" +
                ", id=" + id +
                ", title=" + title +
                ", author=" + author +
                ", content=" + content +
                ", createTime=" + createTime +
                ", readingCount=" + readingCount +
                ", itCategoryId=" + itCategoryId +
                ", userId=" + userId +
                "}";
    }
}
