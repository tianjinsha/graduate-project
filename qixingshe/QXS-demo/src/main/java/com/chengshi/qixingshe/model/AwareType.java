package com.chengshi.qixingshe.model;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.IdType;
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
@TableName("aware_type")
@Data
public class AwareType extends Model<AwareType> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 标签类型名称
     */
    private String cname;
    /**
     * 标签类型描述
     */
    @TableField("cDescription")
    private String description;

    /**
     * 排序
     */
    private Integer sort;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "AwareType{" +
        ", id=" + id +
        ", cname=" + cname +
        ", description=" + description +
        "}";
    }
}
