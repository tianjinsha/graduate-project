package com.chengshi.fitness.model;

import java.util.Date;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 私教打卡
 * </p>
 *
 * @author ${author}
 * @since 2018-12-16
 */
@TableName("coach_card")
public class CoachCard extends Model<CoachCard> {

    private static final long serialVersionUID = 1L;

    /**
     * 私教打卡id
     */
    private Integer id;
    /**
     * 私教id
     */
    private Integer coachId;
    /**
     * 上班时间
     */
    private Date createTime;
    /**
     * 下班时间
     */
    private Date endTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCoachId() {
        return coachId;
    }

    public void setCoachId(Integer coachId) {
        this.coachId = coachId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "CoachCard{" +
        ", id=" + id +
        ", coachId=" + coachId +
        ", createTime=" + createTime +
        ", endTime=" + endTime +
        "}";
    }
}
