/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2010 All Rights Reserved.
 */
package com.lerroy.pussboots.core.cache.springcacheannotation;

/**
 * Created by chunhong.pch on 18/6/24.
 */
public class MyCacheKeyGenerator {
    public static String generateCacheKey(String... args) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String arg : args) {
            stringBuilder.append(arg + "#");
        }
        return stringBuilder.toString();
    }
}