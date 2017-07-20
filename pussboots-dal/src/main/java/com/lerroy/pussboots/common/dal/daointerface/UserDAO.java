/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2010 All Rights Reserved.
 */
package com.lerroy.pussboots.common.dal.daointerface;

import com.lerroy.pussboots.common.dal.daoobject.UserDO;

/**
 * Created by chunhong.pch on 17/7/16.
 */
public interface UserDAO {
    public long insert(UserDO userDO);

    public UserDO get(long id);
}