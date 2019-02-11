package com.chengshi.qixingshe.model;

import com.baomidou.mybatisplus.activerecord.Model;
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
public class Aware extends Model<Aware> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Integer id;
    /**
     * 问题标题
     */
    private String title;
    /**
     * 标签图像
     */
    private String thumb;
    /**
     * 问题描述
     */
    private String description;
    /**
     * 关注数
     */
    private Integer attentionCount;
    /**
     * 标签
     */
    private String tags;
    /**
     * 回答数
     */
    private Integer answerCount;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 用户Id
     */
    private Integer userId;
    /**
     * 状态
     */
    private String status;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Aware{" +
                ", id=" + id +
                ", title=" + title +
                ", thumb=" + thumb +
                ", description=" + description +
                ", attentionCount=" + attentionCount +
                ", tags=" + tags +
                ", answerCount=" + answerCount +
                ", createTime=" + createTime +
                ", userId=" + userId +
                "}";
    }
}
