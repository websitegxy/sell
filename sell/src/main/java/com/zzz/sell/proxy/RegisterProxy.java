package com.zzz.sell.proxy;

import com.zzz.sell.bean.Register;
import com.zzz.sell.contants.SystemConfig;
import com.zzz.sell.exception.CheckParamException;
import com.zzz.sell.reflect.RegisterReflect;
import com.zzz.sell.service.ConfigService;
import com.zzz.sell.utils.SpringBeanUtil;
import com.zzz.sell.vo.RegisterReqVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;

/**
 * 注册器代理
 * @author zzz
 */
@Component
public class RegisterProxy implements Register{
    @Autowired
    private ConfigService configService;
    private Register register;

    public RegisterProxy() {

    }
    private void initRegister(){
        //获取系统配置的注册方式
        String type = configService.getSystemConfigByCode(SystemConfig.REGISTER);
        //加载需代理的注册器
        try {
            register =SpringBeanUtil.getBean(RegisterReflect.getRegister(type));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public boolean isUserExist(RegisterReqVo registerReqVo) {
        if(register == null){
            //初始化注册器
            initRegister();
        }
        return register.isUserExist(registerReqVo);
    }

    @Override
    public boolean registerUser(RegisterReqVo registerReqVo) {
        if(register == null){
            //初始化注册器
            initRegister();
        }
        return register.registerUser(registerReqVo);
    }

    @Override
    public boolean checkParam (RegisterReqVo registerReqVo, HttpSession session) throws CheckParamException {
        if(register == null){
            //初始化注册器
            initRegister();
        }
        return register.checkParam(registerReqVo,session);
    }

    public void setRegister(Register register) {
        this.register = register;
    }
    public Register getRegister() {
        return register;
    }
}
