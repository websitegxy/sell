package com.zzz.sell.bean;

import com.zzz.sell.vo.RegisterReqVo;

public interface Register {
    boolean isUserExist(RegisterReqVo registerReqVo);
    boolean registerUser(RegisterReqVo registerReqVo);

}
