package com.zzz.sell.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.zzz.sell.pojo.SysUser;
import com.zzz.sell.response.HotelResult;
import com.zzz.sell.service.UserService;
import com.zzz.sell.utils.SmsUtil;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Api(description = "用户登录注册相关操作")
@RestController
@SessionAttributes("user")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userServivce;

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/doRegist", method = RequestMethod.POST)
    @ResponseBody
    public HotelResult doRegist(@RequestBody SysUser user, HttpSession httpSession, String verifycode) {
        HotelResult result = new HotelResult();
        JSONObject json = (JSONObject)httpSession.getAttribute("verifyCode");
        if(!json.getString("verifyCode").equals(verifycode)){
            result.setMsg("验证码错误");
            result.setStatus(0);
        } else {
            if (userServivce.Regist(user)) {
            result.setMsg("用户已存在");
            result.setStatus(0);
        } else {// 验证码正确 并且 用户信息不存在
            result.setMsg("用户注册成功");
            result.setStatus(1);
        }

        }
        result.setData(user);
        return result;

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


    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/sendMsg/{phone}", method = RequestMethod.GET)
    @ResponseBody
    public HotelResult sendMsg(@PathVariable String phone, HttpSession session) {
        int verifycode = SmsUtil.getRandom();
        SmsUtil.sendSms(phone, verifycode);
        session.setAttribute("verifycode", String.valueOf(verifycode));
        String data = "{phone:" + phone + ",verifycode:" + verifycode + "}";
        return new HotelResult().ok(data);
    }
}
