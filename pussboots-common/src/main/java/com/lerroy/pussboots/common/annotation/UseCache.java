/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2010 All Rights Reserved.
 */
package com.lerroy.pussboots.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by chunhong.pch on 16/12/17.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UseCache {
    /**
     * 使用@UseCache(duration = 1000*60*60)表示一个方法是否使用缓存,以及配置有效期
     * @return
     */
    public long duration() default 1000 * 60 * 60;
}
