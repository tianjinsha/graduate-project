package com.chengshi.qixingshe.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @author ${author}
 * @since 2018-12-10
 */
@Data
@TableName("aware_tags")
public class AwareTags extends Model<AwareTags> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键，标签ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 标签名称
     */
    private String tname;
    /**
     * 表情描述
     */
    @TableField("tDescription")
    private String description;
    /**
     * 关注数量
     */
    private Integer attentionCount;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 标签类型
     */
    private Integer awareTypeId;

    private AwareType awareType;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "AwareTags{" +
                ", id=" + id +
                ", tname=" + tname +
                ", description=" + description +
                ", attentionCount=" + attentionCount +
                ", createTime=" + createTime +
                ", awareTypeId=" + awareTypeId +
                "}";
    }
}
