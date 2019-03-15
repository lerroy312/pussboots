/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2010 All Rights Reserved.
 */
package com.lerroy.pussboots.core.cache.springcacheannotation;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

/**
 * Created by chunhong.pch on 18/6/24.
 */
public interface CacheUserService {
    @Cacheable(value = "UserService", key = "#id")
    CacheUserModel findById(String id);

    @CachePut(value = "UserService", key = "#userModel.id")
    CacheUserModel updateName(CacheUserModel userModel);

    @CacheEvict(value = "UserService", key = "T(com.lerroy.pussboots.core.cache.springcacheannotation.MyCacheKeyGenerator).generateCacheKey(#id)", beforeInvocation = true)
    void deleteById(String id);
}