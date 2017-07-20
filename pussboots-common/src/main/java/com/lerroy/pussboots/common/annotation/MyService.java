/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2010 All Rights Reserved.
 */
package com.lerroy.pussboots.common.annotation;

/**
 * Created by chunhong.pch on 16/12/17.
 */
@SofaService(uniqueId = "mySerivce")
public class MyService {
    /**
     * 使用注解表面name字段最长5字符
     */
    @MaxLength(value = 5)
    private String name;

    public MyService(String name) {
        this.name = name;
    }

    /**
     * 使用UseCache注解表示该方法可以走缓存
      */
    @UseCache
    public void doService(){
    }

    public String getName() {
        return name;
    }
}
