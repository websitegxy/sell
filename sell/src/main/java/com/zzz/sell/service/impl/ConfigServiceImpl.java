package com.zzz.sell.service.impl;

import com.zzz.sell.dao.SysConfigDao;
import com.zzz.sell.service.ConfigService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author zzz
 * @description 系统配置实现service
 * @date 2020/3/4
 */
@Service
public class ConfigServiceImpl implements ConfigService{
    @Resource
    private SysConfigDao sysConfigDao;
    @Override
    public String getSystemConfigByCode(String code) {

        return sysConfigDao.findSysConfigByCode(code);
    }
}
