package com.zzz.sell.bean;

import com.zzz.sell.contants.DefaultContants;
import com.zzz.sell.vo.RegisterReqVo;
import com.zzz.sell.annotation.Registers;

/**
 * @author zzz
 * @description 账号密码注册器
 * @date 2020/3/4
 */
@Registers(DefaultContants.REGISTER_TYPE_ONE)
public class UsernamePasswordRegister implements Register{
    @Override
    public boolean isUserExist(RegisterReqVo registerReqVo) {
        return false;
    }

    @Override
    public boolean registerUser(RegisterReqVo registerReqVo) {
        return false;
    }
}
