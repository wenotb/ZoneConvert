package com.example.common;

import lombok.Data;

/**
 * 功能：
 * 作者：
 * 日期： 2024/2/12 21:00
 */
@Data
public class Result {
    private int code;
    private String msg;
    private Long total;
    private Object data;

    public static Result fail(){
        return result(400,"失败",0L,null);
    }

    public static Result suc(){
        return result(200,"成功",0L,null);
    }

    public static Result suc(Object data){
        return result(200,"成功",0L,data);
    }

    public static Result suc(Object data,Long total){
        return result(200,"成功",total,data);
    }


    private static Result result(int code ,String msg,Long total,Object data){
        Result res = new Result();

        res.setData(data);
        res.setMsg(msg);
        res.setCode(code);
        res.setTotal(total);
        return res;
    }
}