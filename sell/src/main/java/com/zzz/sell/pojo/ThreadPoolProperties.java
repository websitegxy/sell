package com.zzz.sell.pojo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author jason
 * @version 1.0
 * @date 2020/3/6 22:43
 */
@ConfigurationProperties("executor")
@Component
@Data
public class ThreadPoolProperties {
    private Integer corePoolSize;
    private Integer maxPoolSize;
    private Integer queueCapacity;
    private Integer keepAliveSeconds;
    private String threadNamePrefix;
}
