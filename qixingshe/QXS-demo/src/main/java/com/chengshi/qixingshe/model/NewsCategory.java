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
@TableName("news_category")
public class NewsCategory extends Model<NewsCategory> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 新闻种类名称
     */

    private String cname;
    /**
     * 新闻种类描述
     */
    @TableField("cDescription")
    private String description;
    /**
     * 新闻种类排序
     */
    private Integer sort;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "NewsCategory{" +
                ", id=" + id +
                ", cname=" + cname +
                ", description=" + description +
                ", sort=" + sort +
                "}";
    }
}
