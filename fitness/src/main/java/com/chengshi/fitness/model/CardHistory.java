package com.chengshi.fitness.model;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 *  办卡记录
 * </p>
 *
 * @author ${author}
 * @since 2018-12-16
 */
@Data
@TableName("card_history")
public class CardHistory extends Model<CardHistory> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private Date createTime;
    /**
     * 会员id
     */
    private Integer memberId;
    /**
     * 卡号
     */
    private Integer cardNumber;
    /**
     * 失效时间
     */
    private Date disableTime;
    /**
     * 卡片种类
     */
    private Integer cardId;



    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "CardHistory{" +
        ", id=" + id +
        ", createTime=" + createTime +
        ", memberId=" + memberId +
        ", cardNumber=" + cardNumber +
        ", disableTime=" + disableTime +
        ", cardId=" + cardId +
        "}";
    }
}
