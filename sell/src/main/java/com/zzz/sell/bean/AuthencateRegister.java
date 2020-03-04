package com.zzz.sell.bean;

import com.zzz.sell.annotation.Registers;
import com.zzz.sell.contants.DefaultContants;
import com.zzz.sell.dao.UserDao;
import com.zzz.sell.exception.CheckParamException;
import com.zzz.sell.vo.RegisterReqVo;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * @author zzz
 * @description 管理员认证注册器
 * @date 2020/3/4
 */
@Component
@Registers(DefaultContants.REGISTER_TYPE_THREE)
public class AuthencateRegister implements Register{
    @Resource
    private UserDao userDao;
    @Override
    public boolean isUserExist(RegisterReqVo registerReqVo) {
        System.out.println("username=" + userDao.findUserByUserName("root"));
        return false;
    }

    @Override
    public boolean registerUser(RegisterReqVo registerReqVo) {
        return false;
    }

    @Override
    public boolean checkParam (RegisterReqVo registerReqVo, HttpSession session) throws CheckParamException {
        return false;
    }
}
