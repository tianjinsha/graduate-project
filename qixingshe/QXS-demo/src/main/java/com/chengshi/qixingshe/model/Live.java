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
public class Live extends Model<Live> {

    private static final long serialVersionUID = 1L;

    /**
     * 生活文章ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 文章标题
     */
    private String title;
    /**
     * 文章内容
     */
    private String content;
    /**
     * 阅读数量
     */
    private Integer readingCount;
    /**
     * 不喜欢数量
     */
    private Integer likeCount;
    /**
     * 喜欢数量
     */
    private Integer dislikeCount;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 用户ID
     */
    private Integer userId;
    /**
     * 话题id
     */
    private Integer topicId;

    /**
     * 状态
     */
    private String status;

    private LiveTopic liveTopic;

    private User user;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Live{" +
                ", id=" + id +
                ", title=" + title +
                ", content=" + content +
                ", readingCount=" + readingCount +
                ", likeCount=" + likeCount +
                ", dislikeCount=" + dislikeCount +
                ", createTime=" + createTime +
                ", userID=" + userId +
                ", topicId=" + topicId +
                "}";
    }
}
