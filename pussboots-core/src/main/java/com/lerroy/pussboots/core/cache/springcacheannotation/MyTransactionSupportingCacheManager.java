/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2010 All Rights Reserved.
 */
package com.lerroy.pussboots.core.cache.springcacheannotation;

import org.springframework.cache.Cache;
import org.springframework.cache.transaction.AbstractTransactionSupportingCacheManager;

import java.util.Collection;

/**
 * Created by chunhong.pch on 18/6/24.
 */
public class MyTransactionSupportingCacheManager extends AbstractTransactionSupportingCacheManager {
    private Collection<? extends Cache> caches;

    @Override
    protected Collection<? extends Cache> loadCaches() {
        return caches;
    }

    public void setCaches(Collection<? extends Cache> caches) {
        this.caches = caches;
    }
}