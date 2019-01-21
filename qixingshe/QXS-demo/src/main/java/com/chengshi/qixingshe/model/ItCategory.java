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
@Data
@TableName("it_category")
public class ItCategory extends Model<ItCategory> {

    private static final long serialVersionUID = 1L;

    /**
     * id文章分类
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 分类名称
     */
    private String cname;
    /**
     * 分类描述
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
        return "ItCategory{" +
        ", id=" + id +
        ", cname=" + cname +
        ", description=" + description +
        ", sort=" + sort +
        "}";
    }
}
