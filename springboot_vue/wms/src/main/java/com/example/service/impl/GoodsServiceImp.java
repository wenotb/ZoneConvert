package com.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.entity.Goods;
import com.example.entity.Storage;
import com.example.mapper.GoodsMapper;
import com.example.service.GoodsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xu
 * @since 2024-02-17
 */
@Service
public class GoodsServiceImp extends ServiceImpl<GoodsMapper, Goods> implements GoodsService {

    @Autowired
    GoodsMapper goodsMapper;

    @Override
    public IPage pageCC(IPage<Storage> page, Wrapper wrapper) {
        return goodsMapper.pageCC(page,wrapper);
    }
}
