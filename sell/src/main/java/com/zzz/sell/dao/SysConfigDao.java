package com.zzz.sell.dao;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysConfigDao {
    /**
     * 通过code获取系统配置的值
     * @param configCode
     * @return
     */
    String findSysConfigByCode(String configCode);
}
