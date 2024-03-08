package com.example.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.common.QueryPageParam;
import com.example.common.Result;
import com.example.entity.Goodstype;
import com.example.entity.Storage;
import com.example.service.GoodstypeService;
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
 * @since 2024-02-17
 */
@RestController
@RequestMapping("/goodstype")
public class GoodstypeController {

    @Autowired
    GoodstypeService goodstypeService;

    //新增
    @PostMapping("/sava")
    public Result save(@RequestBody Goodstype goodstype){
        return goodstypeService.save(goodstype) ? Result.suc() : Result.fail();
    }
    //更新
    @PostMapping("/update")
    public Result update(@RequestBody Goodstype goodstype){
        return goodstypeService.updateById(goodstype) ? Result.suc() : Result.fail();
    }
    //删除
    @GetMapping("/del")
    public Result del(@RequestParam String id){
        return goodstypeService.removeById(id) ? Result.suc() : Result.fail();
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

        //IPage result = goodstypeService.pageC(page);
        IPage result = goodstypeService.pageCC(page,lambdaQueryWrapper);
        System.out.println("total==" + result.getTotal());

        return Result.suc(result.getRecords(),result.getTotal());
    }

    @GetMapping("/list")
    public Result list(){
        List list =  goodstypeService.lambdaQuery().list();
        return  Result.suc(list);
    }


}
