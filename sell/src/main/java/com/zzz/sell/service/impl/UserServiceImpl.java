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
    public boolean Regist(SysUser user) {
        // 判断用户是否重复注册
        if (userDao.findByPhone(user.getPhone()) == null) {
            userDao.registerByUsernameAndPassword(user);
            return false;
        }
        return true;
    }
}
