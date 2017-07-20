/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2010 All Rights Reserved.
 */
package com.lerroy.pussboots.common.annotation;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by chunhong.pch on 16/12/17.
 */
public class MyAnnotationDemo {
    public static void main(String[] args) throws Exception {
        MyService myService = new MyService("123456");

        //1.获取类上的注解
        SofaService sofaServicesAnnotation = MyService.class
            .getDeclaredAnnotation(SofaService.class);
        if (sofaServicesAnnotation != null) {
            System.out.println("the unique id is " + sofaServicesAnnotation.uniqueId());
        }

        //2.获取方法上的注解
        Method[] methods = MyService.class.getDeclaredMethods();
        for (Method method : methods) {
            //使用getDeclaredAnnotations(Class<?>)方法获取该method上指定注解
            //这里不能用
            UseCache cacheAnnotation = method.getDeclaredAnnotation(UseCache.class);
            if (cacheAnnotation != null) {
                System.out.println("the method of " + method.getName()
                                   + " can use cache,duration is " + cacheAnnotation.duration());
            }
        }

        //3.获取属性上的注解
        Field[] fields = MyService.class.getDeclaredFields();
        for (Field field : fields) {
            //使用getDeclaredAnnotation(Class<?>)获取属性上指定的注解,同理也可以获取所有注解
            MaxLength lengthAnnotation = field.getDeclaredAnnotation(MaxLength.class);
            if (lengthAnnotation != null) {
                int maxLen = lengthAnnotation.value();
                field.setAccessible(true);
                Object value = field.get(myService);
                if (value instanceof String) {
                    int length = ((String) value).length();
                    if (length > maxLen) {
                        System.out.println("the " + field.getName() + " length is " + length
                                           + " and is exceed max length of " + maxLen);
                    }
                }
            }
        }

    }
}
