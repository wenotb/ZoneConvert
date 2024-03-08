package com.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
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
 * @since 2024-02-16
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("menu")
@ApiModel(value = "Menu对象", description = "")
public class Menu extends Model<Menu> {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("menuCode")
    private String menuCode;

    @TableField("menuName")
    private String menuName;

    @TableField("menuLevel")
    private String menuLevel;

    @TableField("menuParentCode")
    private String menuParentCode;

    @TableField("menuClick")
    private String menuClick;

    @TableField("menuRight")
    private String menuRight;

    @TableField("menuComponent")
    private String menuComponent;

    @TableField("menuIcon")
    private String menuIcon;

    @Override
    public Serializable pkVal() {
        return this.id;
    }
}
