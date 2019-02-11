package com.chengshi.qixingshe.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
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
@TableName("live_topic")
public class LiveTopic extends Model<LiveTopic> {

    private static final long serialVersionUID = 1L;

    /**
     * 话题ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 话题名称
     */
    private String cname;
    /**
     * 头像
     */
    private String thumb;
    /**
     * 话题描述
     */
    @TableField("cDescription")
    private String description;
    /**
     * 文章数量
     */
    private Integer articleCount;
    /**
     * 关注数量
     */
    private Integer attentionCount;
    /**
     * 创建时间
     */
    private Date createTime;

    private Integer sort;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "LiveTopic{" +
                ", id=" + id +
                ", cname=" + cname +
                ", thumb=" + thumb +
                ", description=" + description +
                ", articleCount=" + articleCount +
                ", attentionCount=" + attentionCount +
                ", createTime=" + createTime +
                "}";
    }
}
