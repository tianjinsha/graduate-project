package com.chengshi.fitness.model;

import com.baomidou.mybatisplus.enums.IdType;
import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 会员卡类型
 * </p>
 *
 * @author ${author}
 * @since 2018-12-16
 */
public class Card extends Model<Card> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id（编号）
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 名称
     */
    private String name;
    /**
     * 有效次数
     */
    private Integer useCount;
    /**
     * 有效天数
     */
    private Integer useTime;
    /**
     * 价格
     */
    private String money;
    /**
     * 折扣
     */
    private BigDecimal discount;
    /**
     * 创建时间
     */
    private String createTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getUseCount() {
        return useCount;
    }

    public void setUseCount(Integer useCount) {
        this.useCount = useCount;
    }

    public Integer getUseTime() {
        return useTime;
    }

    public void setUseTime(Integer useTime) {
        this.useTime = useTime;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Card{" +
        ", id=" + id +
        ", name=" + name +
        ", useCount=" + useCount +
        ", useTime=" + useTime +
        ", money=" + money +
        ", discount=" + discount +
        ", createTime=" + createTime +
        "}";
    }
}
