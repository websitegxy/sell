package com.zzz.sell.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

/**
 * @author zzz
 * @description 注册请求vo
 * @date 2020/3/4
 */
@ApiModel(description = "注册账号实体")
@Data
@ToString
public class RegisterReqVo {
    @ApiModelProperty(value = "账号",example = "123456",required = false)
    private String username;
    @ApiModelProperty(value = "密码",example = "123456",required = true)
    private String password;
    @ApiModelProperty(value= "手机号",example = "15221069068",required = false)
    private String phone;
    @ApiModelProperty(value="手机验证码",example = "123456",required = false)
    private String verifyCode;
}
