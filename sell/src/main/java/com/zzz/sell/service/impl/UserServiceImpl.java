package com.zzz.sell.service.impl;

import com.zzz.sell.dao.UserDao;
import com.zzz.sell.pojo.SysUser;
import com.zzz.sell.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public boolean registByPhone(SysUser user) {
        if(userDao.registerByUsernameAndPassword(user) == 1){
            return true;
        }
        return false;
    }

    @Override
    public boolean existUserByPhone(SysUser user) {

        return userDao.findByPhone(user.getPhone()) != null;
    }
}
