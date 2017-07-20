/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2010 All Rights Reserved.
 */
package com.lerroy.pussboots.common.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by chunhong.pch on 17/1/23.
 */
public class MyClassReflectionDemo {
    public static void main(String[] args) throws Exception {
        MyClass myClass = new MyClass();
        Field field = myClass.getClass().getDeclaredField("name");
        System.out.println(field);
        //通过反射创建一个对象
        Object object = Class.forName("reflection.MyClass");

        //获取name属性,注意object.getClass().getFiled()方法是获取Class类本身的属性
        Field field1 = object.getClass().getDeclaredField("name");

        //通过反射调用,设置某个对象的属性
        field1.setAccessible(true);
        field1.set(object, "xxxx");

        //通过get直接获取属性
        System.out.println(field1.get(object));

        //通过反射调用某个对象的方法
        Method method = object.getClass().getDeclaredMethod("getName", null);
        System.out.println(method.invoke(object));
    }
}
