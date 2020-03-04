package com.zzz.sell.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @author zzz
 * @description 获取spring管理的bean
 * @date 2020/3/4
 */
@Component
public class SpringBeanUtil implements ApplicationContextAware {

        private static ApplicationContext applicationContext;

        @Override
        public void setApplicationContext(ApplicationContext context) throws BeansException {
            if (Objects.isNull(applicationContext)) {
                applicationContext = context;
            }
        }

        public static Object getBean(String name) {
            return applicationContext.getBean(name);
        }

        public static <T> T getBean(Class<T> clazz) {
            return applicationContext.getBean(clazz);
        }
}
