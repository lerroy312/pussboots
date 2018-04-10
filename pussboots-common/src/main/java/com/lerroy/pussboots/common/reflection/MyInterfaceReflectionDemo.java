/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2010 All Rights Reserved.
 */
package com.lerroy.pussboots.common.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by chunhong.pch on 16/12/17.
 */
public class MyInterfaceReflectionDemo {
    public static void main(String[] args) throws Exception {
        Class myInterfaceImplClass = Class.forName("reflection.MyInterfaceImpl");
        System.out.println("full class name is " + myInterfaceImplClass.getName());
        System.out.println("package name is " + myInterfaceImplClass.getPackage().getName());

        Class superClass = myInterfaceImplClass.getSuperclass();
        System.out.println("super class name is " + superClass.getName());

        //使用默认构造方法生产一个实例.(默认的构造方法不能是private)
        Object instance = myInterfaceImplClass.newInstance();

        //该类中的所有方法
        Method methods[] = myInterfaceImplClass.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println("method name is " + method.getName());
            //入参个数
            System.out.println("method parameter count is " + method.getParameterCount());
            //入参类型
            System.out.println("method parameter types is " + method.getParameterTypes());
            //返回值类型
            System.out.println("method return type is " + method.getReturnType());
            //抛出异常声明
            System.out.println("method exceptions types is " + method.getExceptionTypes());

            //通过反射调用方法.对于private类型的方法,必须使用setAccessible(true);设置为可访问
            if (method.getName().equals("myPrivateMethod")) {
                method.setAccessible(true);
                method.invoke(instance, "hello");
            }
        }

        //该类所实现的所有接口
        Class interfaces[] = myInterfaceImplClass.getInterfaces();
        for (Class myInterface : interfaces) {
            System.out.println("implemented interface is " + myInterface.getName());
        }

        //该类的所有构造器,并调用构造器
        Constructor constructors[] = myInterfaceImplClass.getConstructors();
        for (Constructor constructor : constructors) {
            if (constructor.getParameterCount() == 0) {
                System.out.println(
                    "construct a object use default constructor," + constructor.newInstance());
            }
            if (constructor.getParameterCount() == 1) {
                System.out.println(
                    "construct a object use one parameter," + constructor.newInstance("hello"));
            }
        }

        //获取该类的所有属性。注意myInterfaceImplClass.getFields();获取的是Class对象本身的属性,不是其所指的对象。因此getFields返回是空数组
        Field fields[] = myInterfaceImplClass.getDeclaredFields();
        for (Field field : fields) {
            //对于private属性,必须设置accessible = true
            field.setAccessible(true);
            System.out.println(
                "the filed name is " + field.getName() + ",value is " + field.get(instance));
        }

    }
}
