package com.chengshi.fitness.model;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 私教列表
 * </p>
 *
 * @author ${author}
 * @since 2018-12-16
 */
public class Coach extends Model<Coach> {

    private static final long serialVersionUID = 1L;

    /**
     * 私教id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 私教名称
     */
    private String name;
    private String sex;
    private Integer age;
    /**
     * 私教 头像
     */
    private String thumb;
    /**
     * 个人介绍
     */
    private String description;


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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Coach{" +
        ", id=" + id +
        ", name=" + name +
        ", sex=" + sex +
        ", age=" + age +
        ", thumb=" + thumb +
        ", description=" + description +
        "}";
    }
}
