/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2010 All Rights Reserved.
 */
package com.lerroy.pussboots.core.cache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * Created by chunhong.pch on 17/12/5.
 */
public class GuavaCacheDemo {
    /**
     * loading cache的作用
     * 当缓存存在时，则直接返回，否则使用load方法加载
     *
     * @throws ExecutionException
     */
    public static void loadingCacheDemo() throws ExecutionException {
        LoadingCache<String, String> cache = CacheBuilder.newBuilder().initialCapacity(10).maximumSize(10)
            .expireAfterAccess(1, TimeUnit.DAYS).build(new CacheLoader<String, String>() {
                @Override
                public String load(String s) throws Exception {
                    //模拟从数据源加载
                    System.out.println(s);
                    return s;
                }
            });
        for(int i=0;i<20 ;i++){
            cache.get(String.valueOf(i));
        }
        for(int i=0;i<10;i++){
            cache.get(String.valueOf(i));
        }
    }

    /**
     * 在get时，如果不存在，则使用指定方法加载
     *
     * @throws ExecutionException
     */
    public static void loadWhenNotGetDemo() throws ExecutionException {
        Cache<String, String> cache = CacheBuilder.newBuilder().initialCapacity(10)
            .expireAfterAccess(1, TimeUnit.DAYS).build();

        String value = cache.get("a", new Callable<String>() {
            @Override public String call() throws Exception {
                return String.valueOf(System.currentTimeMillis());
            }
        });
        System.out.println(value);
    }

    public static void main(String[] args) throws Exception {
        loadingCacheDemo();
    }
}
