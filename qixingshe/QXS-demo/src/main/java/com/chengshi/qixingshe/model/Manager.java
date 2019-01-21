package com.chengshi.qixingshe.model;

import java.util.Date;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author ${author}
 * @since 2018-12-01
 */
@Data
public class Manager extends Model<Manager> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID，自增
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 账号
     */
    private String account;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 创建时时间
     */
    private Date createTime;
    /**
     * 上次登录时间
     */
    private Date lastTime;
    /**
     * 权限ID
     */
    private Integer authorityId;

    /**
     * 状态
     */
    private String status;

    /**
     * 邮箱
     */
    private String email;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Manager{" +
        ", id=" + id +
        ", account=" + account +
        ", username=" + username +
        ", password=" + password +
        ", createTime=" + createTime +
        ", lastTime=" + lastTime +
        ", authorityId=" + authorityId +
        ", status=" + status +
        "}";
    }
}
