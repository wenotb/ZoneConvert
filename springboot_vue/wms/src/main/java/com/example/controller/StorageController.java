package com.example.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.common.QueryPageParam;
import com.example.common.Result;
import com.example.entity.Menu;
import com.example.entity.Storage;
import com.example.mapper.StorageMapper;
import com.example.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xu
 * @since 2024-02-16
 */
@RestController
@RequestMapping("/storage")
public class StorageController {

    @Autowired
    StorageService storageService;

    //新增
    @PostMapping("/sava")
    public Result save(@RequestBody Storage storage){
        return storageService.save(storage) ? Result.suc() : Result.fail();
    }
    //更新
    @PostMapping("/update")
    public Result update(@RequestBody Storage storage){
        return storageService.updateById(storage) ? Result.suc() : Result.fail();
    }
    //删除
    @GetMapping("/del")
    public Result del(@RequestParam String id){
        return storageService.removeById(id) ? Result.suc() : Result.fail();
    }

    @PostMapping("/listPageCC")
    public Result listPageCC(@RequestBody QueryPageParam query){
        HashMap param = query.getParam();
        String name = (String) param.get("name");


        Page<Storage> page =  new Page<>();
        page.setCurrent(query.getPageNum());
        page.setSize(query.getPageSize());

        LambdaQueryWrapper<Storage> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        if(StringUtils.isNotBlank(name) && !"null".equals(name)){
            lambdaQueryWrapper.like(Storage::getName,name);
        }

        //IPage result = StorageService.pageC(page);
        IPage result = storageService.pageCC(page,lambdaQueryWrapper);
        System.out.println("total==" + result.getTotal());

        return Result.suc(result.getRecords(),result.getTotal());
    }

    @GetMapping("/list")
    public Result list(){
        List list =  storageService.lambdaQuery().list();
        return  Result.suc(list);
    }

}
