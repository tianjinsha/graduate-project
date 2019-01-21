package com.chengshi.fitness.model;

import com.baomidou.mybatisplus.enums.IdType;
import java.math.BigDecimal;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 消费记录
 * </p>
 *
 * @author ${author}
 * @since 2018-12-16
 */
@TableName("consumer_history")
public class ConsumerHistory extends Model<ConsumerHistory> {

    private static final long serialVersionUID = 1L;

    /**
     * 消费id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 会员id
     */
    private Integer memberId;
    /**
     * 私教id
     */
    private Integer coachId;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 消费金额
     */
    private BigDecimal money;
    /**
     * 备注
     */
    private String comment;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
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

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "ConsumerHistory{" +
        ", id=" + id +
        ", memberId=" + memberId +
        ", coachId=" + coachId +
        ", createTime=" + createTime +
        ", money=" + money +
        ", comment=" + comment +
        "}";
    }
}
