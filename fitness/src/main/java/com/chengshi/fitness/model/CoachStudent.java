package com.chengshi.fitness.model;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 教练学员
 * </p>
 *
 * @author ${author}
 * @since 2018-12-16
 */
@TableName("coach_student")
public class CoachStudent extends Model<CoachStudent> {

    private static final long serialVersionUID = 1L;

    /**
     * 教练学员
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 私教id
     */
    private Integer coachId;
    /**
     * 会员id
     */
    private Integer memberId;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 截至时间
     */
    private Date deadline;


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

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "CoachStudent{" +
        ", id=" + id +
        ", coachId=" + coachId +
        ", memberId=" + memberId +
        ", createTime=" + createTime +
        ", deadline=" + deadline +
        "}";
    }
}
