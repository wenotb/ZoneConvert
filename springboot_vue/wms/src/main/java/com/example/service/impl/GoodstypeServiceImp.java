package com.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.entity.Goodstype;
import com.example.entity.Storage;
import com.example.mapper.GoodstypeMapper;
import com.example.service.GoodstypeService;
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
public class GoodstypeServiceImp extends ServiceImpl<GoodstypeMapper, Goodstype> implements GoodstypeService {

    @Autowired
    GoodstypeMapper goodstypeMapper;

    @Override
    public IPage pageCC(IPage<Storage> page, Wrapper wrapper) {
        return goodstypeMapper.pageCC(page,wrapper);
    }
}
