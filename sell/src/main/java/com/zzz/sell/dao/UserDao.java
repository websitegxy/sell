package com.zzz.sell.dao;

import com.zzz.sell.pojo.SysUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {
     SysUser findUserByUserName(String username);
     //根据手机号查询
     SysUser findByPhone(String phone);
     //注册用户和密码
     void registerByUsernameAndPassword(SysUser user);
}
