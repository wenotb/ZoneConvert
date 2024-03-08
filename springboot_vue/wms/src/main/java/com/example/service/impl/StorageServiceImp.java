package com.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.entity.Storage;
import com.example.mapper.StorageMapper;
import com.example.service.StorageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xu
 * @since 2024-02-16
 */
@Service
public class StorageServiceImp extends ServiceImpl<StorageMapper, Storage> implements StorageService {

    @Autowired
    StorageMapper storageMapper;
    @Override
    public IPage pageCC(IPage<Storage> page, Wrapper wrapper) {
        return storageMapper.pageCC(page,wrapper);
    }
}
