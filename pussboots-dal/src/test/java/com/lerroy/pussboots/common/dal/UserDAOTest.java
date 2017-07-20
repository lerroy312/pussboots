/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2010 All Rights Reserved.
 */
package com.lerroy.pussboots.common.dal;

import com.lerroy.pussboots.common.dal.daointerface.UserDAO;
import com.lerroy.pussboots.common.dal.daoobject.UserDO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by chunhong.pch on 17/7/16.
 */
public class UserDAOTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/common-dal.xml");
        UserDAO userDAO = (UserDAO) context.getBean("userDAO");

        UserDO userDO = new UserDO();
        userDO.setName("lerroy");
        userDO.setAge(27);
        userDO.setAddress("sssssssss");
        userDO.setPhoneNumber("13438991990");
        long id = userDAO.insert(userDO);
        System.out.println(id);
    }
}