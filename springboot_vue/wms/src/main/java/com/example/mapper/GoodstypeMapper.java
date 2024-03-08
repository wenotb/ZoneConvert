package com.example.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.example.entity.Goodstype;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.entity.Storage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xu
 * @since 2024-02-17
 */
@Mapper
public interface GoodstypeMapper extends BaseMapper<Goodstype> {

    IPage pageCC(IPage<Storage> page, @Param(Constants.WRAPPER)Wrapper wrapper);
}
