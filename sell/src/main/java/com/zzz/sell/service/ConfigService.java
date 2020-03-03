package com.zzz.sell.service;

/**
 * @author zzz
 * @description 系统配置service
 * @date 2020/3/4
 */
public interface ConfigService {
    /**
     * 通过配置项code获取系统配置项的值
     * @param code
     * @return
     */
    String getSystemConfigByCode(String code);
}
