package com.chengshi.qixingshe.model;

import java.util.Date;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

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
    @TableId(value = "managerId", type = IdType.AUTO)
    private Integer id;
    /**
     * 账号
     */
    private String account;

    /**
     * 电话号码
     */
    private String phone;

    /**
     * 邮箱
     */
    private String email;

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
     * 角色列表
     */
    List<Role> roles;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
