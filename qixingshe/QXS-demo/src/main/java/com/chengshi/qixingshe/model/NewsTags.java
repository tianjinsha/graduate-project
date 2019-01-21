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
@TableName("news_tags")
public class NewsTags extends Model<NewsTags> {

    private static final long serialVersionUID = 1L;

    /**
     * 新闻标签ID
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
     * 分类ID
     */
    private String categoryId;

    /**
     * 新闻分类
     */
    private NewsCategory newsCategory;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "NewsTags{" +
        ", id=" + id +
        ", tname=" + tname +
        ", description=" + description +
        ", createTime=" + createTime +
        "}";
    }
}
