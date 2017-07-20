/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2010 All Rights Reserved.
 */
package com.lerroy.pussboots.core;

import com.lerroy.pussboots.core.service.UserService;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

/**
 * Created by chunhong.pch on 17/7/10.
 */
public class BeanFactoryDemo {
    private UserService userService;

    public static void main(String[] args) {
        ClassPathResource res = new ClassPathResource("core-service.xml");
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        reader.loadBeanDefinitions(res);
        BeanFactoryDemo demo =  (BeanFactoryDemo)factory.getBean("beanFactoryDemo");
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