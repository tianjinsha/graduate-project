package com.chengshi.fitness.model;


import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 会员
 * </p>
 *
 * @author ${author}
 * @since 2018-12-16
 */
@Data
public class Member extends Model<Member> {

    private static final long serialVersionUID = 1L;

    /**
     * 会员id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 头像
     */
    private String thumb;
    /**
     * 年龄
     */
    private String sex;
    /**
     * 年龄
     */
    private Integer age;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 状态（0-失效，1-在线）
     */
    private String status;
    /**
     * 电话号码
     */
    private String phone;
    /**
     * 活跃度
     */
    private Float hot;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Member{" +
        ", id=" + id +
        ", username=" + username +
        ", thumb=" + thumb +
        ", sex=" + sex +
        ", age=" + age +
        ", createTime=" + createTime +
        ", status=" + status +
        ", phone=" + phone +
        ", hot=" + hot +
        "}";
    }
}
