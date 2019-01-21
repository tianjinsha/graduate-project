package com.chengshi.fitness.model;

import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 游客
 * </p>
 *
 * @author ${author}
 * @since 2018-12-16
 */
public class Visitor extends Model<Visitor> {

    private static final long serialVersionUID = 1L;

    private Integer id;
    /**
     * 姓名
     */
    private String username;
    /**
     * 预留手机号
     */
    private String phone;
    /**
     * 来访时间
     */
    private String createTime;
    /**
     * 意向
     */
    private Integer intention;
    /**
     * 年龄
     */
    private String sex;
    /**
     * 备注
     */
    private String comment;
    /**
     * 年龄
     */
    private Integer age;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Integer getIntention() {
        return intention;
    }

    public void setIntention(Integer intention) {
        this.intention = intention;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Visitor{" +
        ", id=" + id +
        ", username=" + username +
        ", phone=" + phone +
        ", createTime=" + createTime +
        ", intention=" + intention +
        ", sex=" + sex +
        ", comment=" + comment +
        ", age=" + age +
        "}";
    }
}
