package com.example.common;

import lombok.Data;

import java.util.HashMap;

/**
 * 功能：
 * 作者：
 * 日期： 2024/2/12 18:39
 */
@Data
public class QueryPageParam  {
    //默认
    private static int PAGE_SIZE = 20;
    private static int PAGE_NUM =  1;

    private int pageSize =PAGE_SIZE;
    private int pageNum =PAGE_NUM;

    private HashMap param = new HashMap<>();
}