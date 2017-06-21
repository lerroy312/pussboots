/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2010 All Rights Reserved.
 */
package com.lerroy.pussboots.web.springdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by chunhong.pch on 17/6/19.
 */
@Controller
public class HelloWorldSpringMVCDemo {
    @RequestMapping("/helloWorldSpringMVCDemo")
    public String test(ModelMap modelMap) {
        modelMap.put("name","lerroy");
        return "helloWorldSpringMVCDemo.vm";
    }
}