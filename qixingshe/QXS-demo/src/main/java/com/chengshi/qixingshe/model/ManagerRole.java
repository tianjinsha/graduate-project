package com.chengshi.qixingshe.model;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author ${author}
 * @since 2018-12-10
 */
@Data
@TableName("manager_role")
public class ManagerRole extends Model<ManagerRole> {

    private static final long serialVersionUID = 1L;

    /**
     * ID-主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 名称
     */
    private String name;
    /**
     * 标识
     */
    private String identity;
    /**
     * 描述
     */
    private String description;
    /**
     * 创建时间
     */
    private Date createTime;

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
        return "ManagerRole{" +
        ", id=" + id +
        ", name=" + name +
        ", identity=" + identity +
        ", description=" + description +
        ", createTime=" + createTime +
        ", status=" + status +
        "}";
    }
}
