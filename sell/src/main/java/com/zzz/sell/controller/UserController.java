package com.zzz.sell.controller;

import com.zzz.sell.contants.StatusCode;
import com.zzz.sell.contants.TokenContants;
import com.zzz.sell.exception.CheckParamException;
import com.zzz.sell.proxy.RegisterProxy;
import com.zzz.sell.response.HotelResult;
import com.zzz.sell.utils.SmsUtil;
import com.zzz.sell.vo.BaseResponseVo;
import com.zzz.sell.vo.RegisterReqVo;
import com.zzz.sell.vo.SendMsgReqVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpSession;

@Api(description = "用户登录注册相关操作")
@RestController
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private RegisterProxy registerProxy;
    @ApiOperation(value = "注册账号",notes = "注册方式有3种，1.账号密码注册2.手机号注册3.需审核通过后才可注册成功")
    @RequestMapping(value = "/doRegist", method = RequestMethod.POST)
    public BaseResponseVo doRegist(@RequestBody RegisterReqVo reqVo, @ApiIgnore HttpSession session) {
        BaseResponseVo respVo = new BaseResponseVo();
        //检验参数
        try{
            registerProxy.checkParam(reqVo,session);
        }catch (CheckParamException e){
            respVo.setRespCode(StatusCode.ERR_PARAM);
            respVo.setRespDesc(e.getMessage());
            return respVo;
        }
        //查询用户是否已存在
        if(registerProxy.isUserExist(reqVo)){
            respVo.setRespDesc(StatusCode.ERR_PARAM);
            respVo.setRespCode(StatusCode.ERR_PARAM_USEREXIST);
            return respVo;
        }
        //注册用户
        if(registerProxy.registerUser(reqVo)){
            logger.info("注册用户成功");
            respVo.setRespCode(StatusCode.SUCCESS);
            respVo.setRespDesc(StatusCode.SUCCESS_DETAIL);
        }else {
            logger.info("注册用户失败");
            respVo.setRespCode(StatusCode.ERR_CODE);
            respVo.setRespDesc(StatusCode.ERR_CODE_DETAIL);
        }
        return respVo;

    }
/*
*
* 	// 前端页面 总共两个按钮 一个是点击发送验证码
		// 一个是注册按钮
		/* 点击发送验证码执行下面的操作 */
    // 调用一个随机数工具类,生成一个验证码
    // 将验证码放在Session中
    // 调用阿里云接口, 将验证码作为短信内容发送给手机用户

    /* 点击注册执行下面的操作 */
    // 从表单中取出用户输入的验证码
    // 从session中取出 验证码
    // 进行比较

  /*  @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/registerVerifyPost", method = RequestMethod.POST)
    @ResponseBody
    public String registerVerifyPost(@RequestBody String userInfo, HttpSession httpSession) {
        SysUser u = new SysUser();
     //   GsonBuilder builder = new GsonBuilder();
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        System.out.println(userInfo);
        logger.debug("用户信息="+ userInfo);
      //  Gson gson = builder.create();
        u = JSON.parseObject(userInfo,SysUser.class);
       // u = gson.fromJson(userInfo, SysUser.class);
        if ((u.getPhone() != null)) {
            int verifyCode = SmsUtil.getRandom();
            SmsUtil.sendSms(u.getPhone(), verifyCode);
            httpSession.setAttribute("verifyCode", String.valueOf(verifyCode));
        }
       // return gson.toJson(u);
        return JSON.toJSONString(u);
    }*/

    @ApiOperation(value = "发送短信验证码")
    @RequestMapping(value = "/sendMsg", method = RequestMethod.POST)
    public HotelResult sendMsg(@RequestBody SendMsgReqVo reqVo, @ApiIgnore HttpSession session) {
        int verifycode = SmsUtil.getRandom();
        SmsUtil.sendSms(reqVo.getPhone(), verifycode);
        session.setAttribute(TokenContants.VERIFY_CODE, String.valueOf(verifycode));
        String data = "{phone:" + reqVo.getPhone() + ",verifycode:" + verifycode + "}";
        return new HotelResult().ok(data);
    }
}
