package com.chengshi.qixingshe.model;

import com.baomidou.mybatisplus.activerecord.Model;

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
public class Collection extends Model<Collection> {

    private static final long serialVersionUID = 1L;

    /**
     * 收藏ID
     */
    private Integer id;
    /**
     * 文章ID
     */
    private Integer articleId;
    /**
     * 收藏时间
     */
    private Date collectionTime;
    /**
     * 文章类型
     */
    private Integer articleType;
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

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public Date getCollectionTime() {
        return collectionTime;
    }

    public void setCollectionTime(Date collectionTime) {
        this.collectionTime = collectionTime;
    }

    public Integer getArticleType() {
        return articleType;
    }

    public void setArticleType(Integer articleType) {
        this.articleType = articleType;
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
        return "Collection{" +
                ", id=" + id +
                ", articleId=" + articleId +
                ", collectionTime=" + collectionTime +
                ", articleType=" + articleType +
                ", userId=" + userId +
                "}";
    }
}
