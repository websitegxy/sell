package com.zzz.sell.pojo;

import lombok.Data;
import lombok.ToString;

/**
 * @author zzz
 * @description sys_merchant_config实体
 * @date 2020/3/4
 */
@Data
@ToString
public class SysMerConfig {
    private String configId;
    private String configName;
    private String configCode;
    private String configValue;
    private String isSystemConfig;
    private String mcid;
    private String udpateTime;

}
