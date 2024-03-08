package com.example.service;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;



/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xu
 * @since 2024-02-11
 */
public interface UserService extends IService<User> {

    IPage pageC(IPage<User> page);


    IPage pageCC(IPage<User> page, Wrapper wrapper);
}
