package com.zzz.sell.bean;

import com.zzz.sell.annotation.Registers;
import com.zzz.sell.contants.DefaultContants;
import com.zzz.sell.vo.RegisterReqVo;

/**
 * @author zzz
 * @description 手机号注册器
 * @date 2020/3/4
 */
@Registers(DefaultContants.REGISTER_TYPE_TWO)
public class PhoneRegister implements Register{
    @Override
    public boolean isUserExist(RegisterReqVo registerReqVo) {
        return false;
    }

    @Override
    public boolean registerUser(RegisterReqVo registerReqVo) {
        return false;
    }
}
