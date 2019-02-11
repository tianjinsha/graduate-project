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
@TableName("aware_comment")
public class AwareComment extends Model<AwareComment> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Integer id;
    /**
     * 讨论内容
     */
    private String content;
    /**
     * 讨论时间
     */
    private Date createTime;
    /**
     * 认同数量
     */
    private Integer acceptCount;
    /**
     * 否认数量
     */
    private Integer denyCount;
    /**
     * 讨论对象
     */
    private Integer awareId;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getAcceptCount() {
        return acceptCount;
    }

    public void setAcceptCount(Integer acceptCount) {
        this.acceptCount = acceptCount;
    }

    public Integer getDenyCount() {
        return denyCount;
    }

    public void setDenyCount(Integer denyCount) {
        this.denyCount = denyCount;
    }

    public Integer getAwareId() {
        return awareId;
    }

    public void setAwareId(Integer awareId) {
        this.awareId = awareId;
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
        return "AwareComment{" +
                ", id=" + id +
                ", content=" + content +
                ", createTime=" + createTime +
                ", acceptCount=" + acceptCount +
                ", denyCount=" + denyCount +
                ", awareId=" + awareId +
                ", userId=" + userId +
                "}";
    }
}
