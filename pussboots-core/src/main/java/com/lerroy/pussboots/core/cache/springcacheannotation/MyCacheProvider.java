/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2010 All Rights Reserved.
 */
package com.lerroy.pussboots.core.cache.springcacheannotation;

import com.google.common.cache.CacheBuilder;
import org.springframework.cache.Cache;
import org.springframework.cache.support.SimpleValueWrapper;

import java.util.concurrent.TimeUnit;

/**
 * Created by chunhong.pch on 18/6/24.
 */
public class MyCacheProvider implements Cache {
    private String                                        name;

    private com.google.common.cache.Cache<Object, Object> cacheHolder = null;

    public void init() {
        //缓存初始容量为10，有效期为1天
        cacheHolder = CacheBuilder.newBuilder().initialCapacity(10)
            .expireAfterAccess(1, TimeUnit.DAYS).build();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Object getNativeCache() {
        return cacheHolder;
    }

    @Override
    public ValueWrapper get(Object key) {
        Object value = cacheHolder.getIfPresent(key);
        return value == null ? null : new SimpleValueWrapper(value);
    }

    @Override
    public <T> T get(Object key, Class<T> type) {
        Object value = cacheHolder.getIfPresent(key);
        return value == null ? null : (T) value;
    }

    @Override
    public void put(Object key, Object value) {
        cacheHolder.put(key, value);
    }

    @Override
    public void evict(Object key) {
        cacheHolder.invalidate(key);
    }

    @Override
    public void clear() {
        cacheHolder.invalidateAll();
    }

    /**
     * Setter method for property <tt>name</tt>.
     *
     * @param name value to be assigned to property name
     */
    public void setName(String name) {
        this.name = name;
    }
}