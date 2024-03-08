package com.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author xu
 * @since 2024-02-18
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("record")
@ApiModel(value = "Record对象", description = "")
public class Record extends Model<Record> {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("goods")
    private Integer goods;

    @TableField("userId")
    private Integer userId;

    @TableField("admin_id")
    private Integer adminId;

    @TableField("count")
    private Integer count;

    @TableField("createtime")
    private LocalDateTime createtime;

    @TableField("remark")
    private String remark;

    @TableField(exist = false)
    private String action;

    @Override
    public Serializable pkVal() {
        return this.id;
    }

}
