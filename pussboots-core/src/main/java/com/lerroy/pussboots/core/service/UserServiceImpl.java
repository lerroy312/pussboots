/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2010 All Rights Reserved.
 */
package com.lerroy.pussboots.core.service;

import com.lerroy.pussboots.common.dal.daointerface.UserDAO;
import com.lerroy.pussboots.common.dal.daoobject.UserDO;
import com.lerroy.pussboots.core.model.User;

import java.util.logging.Logger;

/**
 * Created by chunhong.pch on 17/7/16.
 */
public class UserServiceImpl implements UserService {
    private static final Logger LOGGER = Logger.getLogger("");
    private UserDAO userDAO;

    @Override
    public long add(User user) {
        return userDAO.insert(user2UserDO(user));
    }

    private UserDO user2UserDO(User user) {
        UserDO userDO = new UserDO();
        userDO.setName(user.getName());
        userDO.setAddress(user.getAddress());
        userDO.setAge(user.getAge());
        userDO.setPhoneNumber(user.getPhoneNumber());
        return userDO;
    }

    /**
     * Setter method for property <tt>userDAO</tt>.
     *
     * @param userDAO value to be assigned to property userDAO
     */
    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }
}