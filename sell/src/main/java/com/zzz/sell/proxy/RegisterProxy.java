package com.zzz.sell.proxy;

import com.zzz.sell.bean.Register;
import com.zzz.sell.reflect.RegisterReflect;
import com.zzz.sell.vo.RegisterReqVo;

public class RegisterProxy implements Register{
    private Register register;
    public RegisterProxy() throws Exception {
        //获取系统配置的注册方式
        String registerType = "2";
        //加载需代理的注册器
        register = RegisterReflect.getRegisterObject(registerType);
    }
    @Override
    public boolean isUserExist(RegisterReqVo registerReqVo) {
        return register.isUserExist(registerReqVo);
    }

    @Override
    public boolean registerUser(RegisterReqVo registerReqVo) {
        return register.registerUser(registerReqVo);
    }

    public static void main(String[] args) {
        try {
            RegisterProxy registerProxy = new RegisterProxy();
            RegisterReqVo reqVo = new RegisterReqVo();
            registerProxy.isUserExist(reqVo);
        } catch (Exception e) {
            System.out.println("请配置注册方式");
            e.printStackTrace();
        }
    }
}
