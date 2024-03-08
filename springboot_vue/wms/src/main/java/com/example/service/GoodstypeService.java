package com.example.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.entity.Goodstype;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.entity.Storage;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xu
 * @since 2024-02-17
 */
public interface GoodstypeService extends IService<Goodstype> {

    IPage pageCC(IPage<Storage> page, Wrapper wrapper);
}
