package com.example.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.example.entity.Record;
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
 * @since 2024-02-18
 */
@Mapper
public interface RecordMapper extends BaseMapper<Record> {

    IPage pageCC(IPage<Record> page,  @Param(Constants.WRAPPER)Wrapper wrapper);
}
