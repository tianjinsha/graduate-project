package com.chengshi.qixingshe.model;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 菜单
 * </p>
 *
 * @author ${author}
 * @since 2018-12-28
 */
@Data
public class Menu extends Model<Menu> {

    private static final long serialVersionUID = 1L;

    /**
     * 菜单ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 菜单标题
     */
    private String title;
    /**
     * 标识
     */
    private String identity;
    /**
     * 图标
     */
    private String icon;
    /**
     * 资源路径
     */
    private String path;
    /**
     * 请求方式
     */
    private String method;
    /**
     * 类型：-菜单-按钮
     */
    private Integer type;
    /**
     * 排序
     */
    private Integer sort;
    /**
     * 状态
     */
    private String status;

    /**
     * 父栏目
     */
    private Integer parent;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Menu{" +
        ", id=" + id +
        ", title=" + title +
        ", identity=" + identity +
        ", icon=" + icon +
        ", path=" + path +
        ", method=" + method +
        ", type=" + type +
        ", sort=" + sort +
        ", status=" + status +
        ", parent=" + parent +
        "}";
    }
}
