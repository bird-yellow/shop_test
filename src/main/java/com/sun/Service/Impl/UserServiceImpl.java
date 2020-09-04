package com.sun.Service.Impl;

import com.sun.Dao.UserDao;
import com.sun.Entity.User;
import com.sun.Service.UserService;
import com.sun.base.BaseDao;
import com.sun.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public BaseDao<User> getBaseDao() {
        return  userDao;
    }
}
