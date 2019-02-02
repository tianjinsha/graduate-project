package com.chengshi.qixingshe.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author ${author}
 * @since 2018-12-06
 */
@Data
public class Role extends Model<Role> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "roleId", type = IdType.AUTO)
    private Integer id;
    /**
     * 角色名称
     */
    private String name;

    /**
     * 角色标识
     */
    private String identity;
    /**
     * 角色描述
     */
    private String description;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 状态
     */
    private String status;

    /**
     * 管理员列表
     */
    private List<Manager> managers;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
