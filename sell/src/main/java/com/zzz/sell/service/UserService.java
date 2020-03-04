package com.zzz.sell.service;

import com.zzz.sell.pojo.SysUser;

public interface UserService {
    /**
     * 注册用户通过手机号
     * @param user
     * @return
     */
    boolean registByPhone(SysUser user);

    /**
     * 通过手机号判断用户是否已存在
     * @param user
     * @return boolean
     */
    boolean existUserByPhone(SysUser user);
}
