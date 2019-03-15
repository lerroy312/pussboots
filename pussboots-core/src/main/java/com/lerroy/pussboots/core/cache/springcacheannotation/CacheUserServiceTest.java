/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2010 All Rights Reserved.
 */
package com.lerroy.pussboots.core.cache.springcacheannotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by chunhong.pch on 18/6/24.
 */
public class CacheUserServiceTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("core-service.xml");
        CacheUserService cacheUserService = (CacheUserService) context.getBean("cacheUserService");
        CacheUserModel userModel = new CacheUserModel("1111","aaaa");
        cacheUserService.updateName(userModel);
        cacheUserService.deleteById("1111");
        cacheUserService.findById("aaa");
    }
}