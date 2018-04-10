/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2010 All Rights Reserved.
 */
package com.lerroy.pussboots.web.springdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by chunhong.pch on 17/6/19.
 */
@Controller
public class HelloWorldSpringMVCDemo {
    @RequestMapping("/helloWorldSpringMVCDemo")
    public void test(ModelMap modelMap , HttpServletResponse response) throws IOException {
        modelMap.put("name","lerroy");
        //return "helloWorldSpringMVCDemo.vm";
        response.sendRedirect("/helloWorldSpringMVCDemo");
    }
}