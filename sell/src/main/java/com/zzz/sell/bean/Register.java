package com.zzz.sell.bean;

import com.zzz.sell.exception.CheckParamException;
import com.zzz.sell.vo.RegisterReqVo;

import javax.servlet.http.HttpSession;

public interface Register {
    boolean isUserExist(RegisterReqVo registerReqVo);
    boolean registerUser(RegisterReqVo registerReqVo);
    boolean checkParam (RegisterReqVo registerReqVo, HttpSession session) throws CheckParamException;

}
