package com.zzz.sell.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

/**
 * @author zzz
 * @description 发送短信请求vo
 * @date 2020/3/4
 */
@Data
@ToString
@ApiModel(description = "发送短信验证码")
public class SendMsgReqVo {
    @ApiModelProperty(value = "手机号",required = true)
    private String phone;
}
