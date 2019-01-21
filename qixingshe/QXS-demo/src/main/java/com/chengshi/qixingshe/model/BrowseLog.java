package com.chengshi.qixingshe.model;

import java.util.Date;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author ${author}
 * @since 2018-12-10
 */
@TableName("browse_log")
public class BrowseLog extends Model<BrowseLog> {

    private static final long serialVersionUID = 1L;

    /**
     * 浏览记录ID
     */
    private Integer id;
    /**
     * 浏览时间
     */
    private Date browseTime;
    /**
     * 文章Id
     */
    private Integer articleId;
    /**
     * 文章 类型
     */
    private Integer articelType;
    /**
     * 用户ID
     */
    private Integer userId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getBrowseTime() {
        return browseTime;
    }

    public void setBrowseTime(Date browseTime) {
        this.browseTime = browseTime;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public Integer getArticelType() {
        return articelType;
    }

    public void setArticelType(Integer articelType) {
        this.articelType = articelType;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "BrowseLog{" +
        ", id=" + id +
        ", browseTime=" + browseTime +
        ", articleId=" + articleId +
        ", articelType=" + articelType +
        ", userId=" + userId +
        "}";
    }
}
