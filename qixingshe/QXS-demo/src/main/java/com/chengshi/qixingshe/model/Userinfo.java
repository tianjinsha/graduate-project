package com.chengshi.qixingshe.model;

import com.baomidou.mybatisplus.activerecord.Model;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @author ${author}
 * @since 2018-12-01
 */
@Data
public class Userinfo extends Model<Userinfo> {

    private static final long serialVersionUID = 1L;

    private Integer id;
    /**
     * 用户姓名
     */
    private String username;
    /**
     * 个人介绍
     */
    private String introduce;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 性别
     */
    private String sex;
    /**
     * 出生日期
     */
    private Date birthday;
    /**
     * 用户ID
     */
    private Integer userId;
    /**
     * 上次登录时间
     */
    private Date lastTime;
    /**
     * 登录次数
     */
    private Integer loginCount;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Userinfo{" +
                ", id=" + id +
                ", username=" + username +
                ", introduce=" + introduce +
                ", createTime=" + createTime +
                ", sex=" + sex +
                ", birthday=" + birthday +
                ", userId=" + userId +
                ", lastTime=" + lastTime +
                ", loginCount=" + loginCount +
                "}";
    }
}
