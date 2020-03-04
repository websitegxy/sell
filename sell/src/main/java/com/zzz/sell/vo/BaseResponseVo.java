package com.zzz.sell.vo;

import lombok.Data;
import lombok.ToString;

/**
 * @author zzz
 * @description 基础返回vo
 * @date 2020/3/3
 */
@Data
@ToString
public class BaseResponseVo {
    private String RespCode;
    private String RespDesc;
}
