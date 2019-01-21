package com.chengshi.fitness.model;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 年龄阶段
 * </p>
 *
 * @author ${author}
 * @since 2018-12-16
 */
@Data
@TableName("age_stage")
public class AgeStage extends Model<AgeStage> {

    private static final long serialVersionUID = 1L;

    /**
     * 阶段id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 年龄阶段
     */
    private String stage;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "AgeStage{" +
        ", id=" + id +
        ", stage=" + stage +
        "}";
    }
}
