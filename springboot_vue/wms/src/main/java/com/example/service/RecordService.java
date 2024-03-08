package com.example.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.entity.Record;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.entity.Storage;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xu
 * @since 2024-02-18
 */
public interface RecordService extends IService<Record> {

    IPage pageCC(IPage<Record> page, Wrapper wrapper);
}
