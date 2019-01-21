package com.chengshi.fitness.model;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 管理员
 * </p>
 *
 * @author ${author}
 * @since 2018-12-16
 */
@Data
public class Manager extends Model<Manager> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 上一次登录时间
     */
    private Date lastTime;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Manager{" +
        ", id=" + id +
        ", username=" + username +
        ", password=" + password +
        ", lastTime=" + lastTime +
        "}";
    }
}
