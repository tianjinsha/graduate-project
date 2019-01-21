package com.chengshi.fitness.model;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 器材名称
 * </p>
 *
 * @author ${author}
 * @since 2018-12-16
 */
@TableName("equipment_type")
public class EquipmentType extends Model<EquipmentType> {

    private static final long serialVersionUID = 1L;

    /**
     * 器材分类ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 器材名称
     */
    private String equipmentName;
    /**
     * 器材种类
     */
    private String type;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "EquipmentType{" +
        ", id=" + id +
        ", equipmentName=" + equipmentName +
        ", type=" + type +
        "}";
    }
}
