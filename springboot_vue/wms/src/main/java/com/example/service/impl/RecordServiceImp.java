package com.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.entity.Record;
import com.example.entity.Storage;
import com.example.mapper.RecordMapper;
import com.example.service.RecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xu
 * @since 2024-02-18
 */
@Service
public class RecordServiceImp extends ServiceImpl<RecordMapper, Record> implements RecordService {

    @Autowired
    RecordMapper recordMapper;

    @Override
    public IPage pageCC(IPage<Record> page, Wrapper wrapper) {
        return recordMapper.pageCC(page,wrapper);
    }
}
