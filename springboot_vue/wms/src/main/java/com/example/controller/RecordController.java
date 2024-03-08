package com.example.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.common.QueryPageParam;
import com.example.common.Result;
import com.example.entity.Goods;
import com.example.entity.Record;
import com.example.entity.Storage;
import com.example.service.GoodsService;
import com.example.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xu
 * @since 2024-02-18
 */
@RestController
@RequestMapping("/record")
public class RecordController {

    @Autowired
    RecordService recordService;

    @Autowired
    GoodsService goodsService;

    @PostMapping("/listPageCC")
    public Result listPageCC(@RequestBody QueryPageParam query){
        HashMap param = query.getParam();
        String name = (String) param.get("name");
        String goodstype = (String) param.get("goodstype");
        String storage = (String) param.get("storage");
        String roleId = (String) param.get("roleId");
        String userId = (String) param.get("userId");


        Page<Record> page =  new Page<>();
        page.setCurrent(query.getPageNum());
        page.setSize(query.getPageSize());

        QueryWrapper<Record> queryWrapper = new QueryWrapper<>();
        queryWrapper.apply(" a.goods=b.id and b.storage = c.id and b.goodstype=d.id");

        if("2".equals(roleId)){
            queryWrapper.apply("a.userId="+userId);
        }


        if(StringUtils.isNotBlank(name) && !"null".equals(name)){
            queryWrapper.like("b.name",name);
        }
        if(StringUtils.isNotBlank(goodstype) && !"null".equals(goodstype)){
           queryWrapper.eq("d.id",goodstype);
        }
        if(StringUtils.isNotBlank(storage) && !"null".equals(storage)){
            queryWrapper.eq("c.id",storage);
        }

        //IPage result = goodsService.pageC(page);
        IPage result = recordService.pageCC(page,queryWrapper);
        System.out.println("total==" + result.getTotal());

        return Result.suc(result.getRecords(),result.getTotal());
    }

    @PostMapping("/sava")
    public Result save(@RequestBody Record record){
        Goods goods = goodsService.getById(record.getGoods());
        int n = record.getCount();
        if(record.getAction().equals("2")){
            n = -n;
            record.setCount(n); // 修改记录
        }
        int num = goods.getCount() + n;
        goods.setCount(num);
        goodsService.updateById(goods);

        return recordService.save(record) ? Result.suc() : Result.fail();
    }

}
