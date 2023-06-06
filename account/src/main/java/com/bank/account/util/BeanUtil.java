package com.bank.account.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class BeanUtil implements ApplicationContextAware {
    private static ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
        log.info("Контекст успешно установлен BeanUtil.class");
    }

    public static <T> T getBean(Class<T> beanClass) {
        log.info("Получен бин указанного типа BeanUtil.class");
        return context.getBean(beanClass);
    }
}
