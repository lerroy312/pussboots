/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2010 All Rights Reserved.
 */
package com.lerroy.pussboots.common.dal.ibatis;

import com.lerroy.pussboots.common.dal.daointerface.UserDAO;
import com.lerroy.pussboots.common.dal.daoobject.UserDO;
import org.apache.ibatis.session.SqlSession;

/**
 * Created by chunhong.pch on 17/7/16.
 */
public class IbatisUserDAO implements UserDAO {
    private SqlSession sqlSession;

    @Override
    public long insert(UserDO userDO) {
        sqlSession.insert("com.lerroy.pussboots.common.dal.daointerface.UserDAO.insert",userDO);
        return userDO.getId();
    }

    @Override
    public UserDO get(long id) {
        return sqlSession.selectOne("com.lerroy.pussboots.common.dal.daointerface.UserDAO.get",id);
    }


    /**
     * Setter method for property <tt>sqlSession</tt>.
     *
     * @param sqlSession value to be assigned to property sqlSession
     */
    public void setSqlSession(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }
}