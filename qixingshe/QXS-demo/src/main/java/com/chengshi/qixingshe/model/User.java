package com.chengshi.qixingshe.model;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import lombok.Data;
import org.apache.ibatis.type.Alias;

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
//@Alias("User")
@Data
public class User extends Model<User> {

    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 用户昵称
     */
    @TableField("nickname")
    private String nickname;
    /**
     * 用户邮箱
     */
    @TableField("email")
    private String email;
    /**
     * 用户电话
     */
    @TableField("phoneNum")
    private String phoneNum;
    /**
     * 用户密码
     */
    @TableField("password")
    private String password;
    /**
     * 是否是官方账号
     */
    @TableField("official")
    private Integer official;
    /**
     * 创建时间
     */
    @TableField("createTime")
    private Date createTime;
    /**
     * 跟新时间
     */
    @TableField("updateTime")
    private Date updateTime;
    /**
     * 状态
     */
    @TableField("status")
    private String status;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "User{" +
        ", id=" + id +
        ", nickname=" + nickname +
        ", email=" + email +
        ", phoneNum=" + phoneNum +
        ", password=" + password +
        ", official=" + official +
        ", updateTime=" + updateTime +
        ", official=" + createTime +
        ", status=" + status +
        "}";
    }
}
