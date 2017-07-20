/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2010 All Rights Reserved.
 */
package com.lerroy.pussboots.web;

import com.lerroy.pussboots.core.model.User;
import com.lerroy.pussboots.core.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by chunhong.pch on 17/7/16.
 */
@Controller
public class UserController {
    private UserService userService;

    @RequestMapping("/addUser")
    public void addUser(String name, int age, String address,String phoneNumber) {
        User user = new User();
        user.setName(name);
        user.setAge(age);
        user.setAddress(address);
        user.setPhoneNumber(phoneNumber);
        userService.add(user);
    }

    /**
     * Setter method for property <tt>userService</tt>.
     *
     * @param userService value to be assigned to property userService
     */
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}