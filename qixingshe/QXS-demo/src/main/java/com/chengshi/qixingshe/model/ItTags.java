package com.chengshi.qixingshe.model;

import com.baomidou.mybatisplus.annotations.TableField;
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
@TableName("it_tags")
public class ItTags extends Model<ItTags> {

    private static final long serialVersionUID = 1L;

    /**
     * it文章标签ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 标签名称
     */
    private String tname;
    /**
     * 标签描述
     */
    @TableField("tDescription")
    private String description;
    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 标签分类
     */
    private Integer categoryId;

    private ItCategory itCategory;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "ItTags{" +
        ", id=" + id +
        ", tname=" + tname +
        ", description=" + description +
        ", createTime=" + createTime +
        "}";
    }
}
