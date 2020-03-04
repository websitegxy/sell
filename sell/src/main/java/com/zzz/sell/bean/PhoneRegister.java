package com.zzz.sell.bean;

import com.zzz.sell.annotation.Registers;
import com.zzz.sell.contants.DefaultContants;
import com.zzz.sell.contants.TokenContants;
import com.zzz.sell.exception.CheckParamException;
import com.zzz.sell.pojo.SysUser;
import com.zzz.sell.service.UserService;
import com.zzz.sell.vo.RegisterReqVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;

/**
 * @author zzz
 * @description 手机号注册器
 * @date 2020/3/4
 */
@Component
@Registers(DefaultContants.REGISTER_TYPE_TWO)
public class PhoneRegister implements Register{
    @Autowired
    private UserService userService;
    @Override
    public boolean isUserExist(RegisterReqVo registerReqVo) {
        SysUser user = new SysUser();
        user.setPassword(registerReqVo.getPassword());
        user.setPhone(registerReqVo.getPhone());
        return userService.existUserByPhone(user);
    }

    @Override
    public boolean registerUser(RegisterReqVo registerReqVo) {
        SysUser user = new SysUser();
        user.setPassword(registerReqVo.getPassword());
        user.setPhone(registerReqVo.getPhone());
        return userService.registByPhone(user);
    }

    @Override
    public boolean checkParam(RegisterReqVo registerReqVo,HttpSession session) throws CheckParamException{
        String verifyCode = session.getAttribute(TokenContants.VERIFY_CODE) == null ?
                "" : session.getAttribute(TokenContants.VERIFY_CODE).toString();
        if(verifyCode.equals(registerReqVo.getVerifyCode())){
            return true;
        }
        throw new CheckParamException("验证码错误");
    }
}
