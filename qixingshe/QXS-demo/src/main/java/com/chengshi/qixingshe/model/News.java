package com.chengshi.qixingshe.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
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
public class News extends Model<News> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 标题
     */
    private String title;
    /**
     * 作者
     */
    private String author;
    /**
     * 来源
     */
    private String source;
    /**
     * 摘要
     */
    private String summary;
    /**
     * 内容
     */
    private String content;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 喜欢数量
     */
    private Integer likeCount;
    /**
     * 阅读数
     */
    private Integer readingCount;
    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 状态
     */
    private String status;

    /**
     * 新闻分类
     */
    private NewsCategory newsCategory;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "News{" +
                ", id=" + id +
                ", title=" + title +
                ", author=" + author +
                ", source=" + source +
                ", summary=" + summary +
                ", content=" + content +
                ", createTime=" + createTime +
                ", likeCount=" + likeCount +
                ", readingCount=" + readingCount +
                ", userId=" + userId +
                "}";
    }
}
