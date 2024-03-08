package com.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author xu
 * @since 2024-02-17
 */

@Data
@Accessors(chain = true)
@TableName("goods")
@ApiModel(value = "Goods对象", description = "")
public class Goods extends Model<Goods> {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("name")
    private String name;

    @TableField("storage")
    private Integer storage;

    @TableField("goodstype")
    private Integer goodstype;

    @TableField("count")
    private Integer count;

    @TableField("remark")
    private String remark;

    @Override
    public Serializable pkVal() {
        return this.id;
    }
}
