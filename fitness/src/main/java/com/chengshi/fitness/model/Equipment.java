package com.chengshi.fitness.model;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 器材列表
 * </p>
 *
 * @author ${author}
 * @since 2018-12-16
 */
public class Equipment extends Model<Equipment> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 编号
     */
    private String number;
    /**
     * 图片
     */
    private String thumb;
    /**
     * 器材名称ID
     */
    private Integer typeId;
    /**
     * 状态，1-默认良好，0-损坏，2-正在维修
     */
    private String status;
    /**
     * 创建时间
     */
    private Date createTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Equipment{" +
        ", id=" + id +
        ", number=" + number +
        ", thumb=" + thumb +
        ", typeId=" + typeId +
        ", status=" + status +
        ", createTime=" + createTime +
        "}";
    }
}
