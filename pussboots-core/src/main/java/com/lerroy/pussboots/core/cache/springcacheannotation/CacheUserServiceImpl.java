/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2010 All Rights Reserved.
 */
package com.lerroy.pussboots.core.cache.springcacheannotation;

/**
 * Created by chunhong.pch on 18/6/24.
 */
public class CacheUserServiceImpl implements CacheUserService {
    @Override
    public CacheUserModel findById(String id) {
        return new CacheUserModel(id, "userName+" + id);
    }

    @Override
    public CacheUserModel updateName(CacheUserModel userModel) {
        return userModel;
    }

    @Override
    public void deleteById(String id) {

    }
}