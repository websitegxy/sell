package com.zzz.sell.contants;

/**
 * @author zzz
 * @description 请求状态码
 * @date 2020/2/28
 */
public class StatusCode {
    public final static String SUCCESS = "0000";
    public final static String SUCCESS_DETAIL = "请求成功";
    public final static String LOGIN_FAILURE = "0001";
    public final static String LOGIN_FAIURE_DETAIL = "登录失败";
    public final static String LOGOUT_FAILURE = "0002";
    public final static String LOGOUT_FAILURE_DETAIL = "注销失败";
    public final static String NO_AUTH = "0003";
    public final static String NO_AUTH_DETAIL = "用户未登录";
    public final static String LOGIN_ERR_PASSWORD = "0004";
    public final static String LOGIN_ERR_PASSWORD_DETAIL = "账号或密码错误";
    public final static String LOGIN_NOT_PERMIT = "0005";
    public final static String LOGIN_NOT_PERMIT_DETAIL = "无访问权限";
    public final static String ERR_PARAM = "0006";
    public final static String ERR_PARAM_DETAIL = "参数错误";
    public final static String ERR_PARAM_USEREXIST = "用户已存在";
    public final static String ERR_CODE = "9999";
    public final static String ERR_CODE_DETAIL = "系统错误";
}
