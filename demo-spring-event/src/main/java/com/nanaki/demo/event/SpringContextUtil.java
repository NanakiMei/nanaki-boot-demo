package com.nanaki.demo.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * bean 初始化前实例化
 *
 */
@Slf4j
public class SpringContextUtil implements BeanFactoryPostProcessor {

    @Configuration
    public static class SpringContextInit {
        @Bean
        public SpringContextUtil springContextUtil(ApplicationContext applicationContext) {
            return new SpringContextUtil(applicationContext);
        }
    }

    private static ApplicationContext applicationContext;

    public SpringContextUtil(ApplicationContext applicationContext) {
        SpringContextUtil.applicationContext = applicationContext;
    }

    private static void checkIfNullThrowException() {
        if (applicationContext == null) {
            throw new IllegalStateException();
        }
    }

    /**
     * 通过bean类型获取bean实例
     * @return may be null
     */
    public static<T> T getBean(Class<T> type) {
        checkIfNullThrowException();
        try {

            return applicationContext.getBean(type);
        } catch (BeansException e) {
            log.debug("从spring容器获取bean[{}]失败", type.getSimpleName());
            return null;
        }
    }

    /**
     * 获取同类型下所有的bean
     * @param type bean 类型
     * @return 可能为 null
     * @since 3.1.8R300.P001
     */
    public static<T> List<T> getBeans(Class<T> type) {
        checkIfNullThrowException();
        try {
            Map<String, T> map = applicationContext.getBeansOfType(type);

            return new ArrayList<>(map.values());
        } catch (BeansException e) {
            log.warn("从spring容器获取bean[{}]集合失败", type.getSimpleName());
            return null;
        }
    }

    /**
     * 通过bean名称获取bean实例
     * @return may be null
     * @since 3.1.8_R600
     */
    public static<T> T getBeanByName(String name, Class<T> type) {
        checkIfNullThrowException();
        try {
            return applicationContext.getBean(name, type);
        } catch (BeansException e) {
            log.warn("从spring容器获取bean[{}]失败", type.getSimpleName());
            return null;
        }
    }


    /**
     * 通过bean类型获取bean实例
     * @return may be null
     */
    public static<T> List<T> getBeansByType(Class<T> beanType) {
        checkIfNullThrowException();
        Map<String, T> beansOfType;
        try {

            beansOfType = applicationContext.getBeansOfType(beanType);
        } catch (BeansException e) {
            log.warn("从spring容器获取bean[{}]集合失败", beanType.getSimpleName());
            return null;
        }

        return new ArrayList<>(beansOfType.values());
    }

    /**
     * Return the property value associated with the given key, or null if the key cannot be resolved.
     * @param key – the property name to resolve
     * @since 3.1.8-v3
     */
    public static Integer getPropertyValue(String key){
        return getPropertyValue(key, Integer.class, null);
    }

    /**
     * Return the property value associated with the given key,
     * or {@code defaultValue} if the key cannot be resolved.
     * @param key the property name to resolve
     * @param defaultValue the default value to return if no value is found
     * @since 3.1.8-v6
     */
    public static Integer getIntegerPropertyWithDefault(String key, Integer defaultValue) {
        return getPropertyValue(key, Integer.class, defaultValue);
    }

    /**
     * Return the property value associated with the given key,
     * @param key the property name to resolve
     * @since 3.1.8_R300.P002
     */
    public static Boolean getBooleanPropertyValue(String key) {
        return getPropertyValue(key, Boolean.class, Boolean.FALSE);
    }

    /**
     * Return the property value associated with the given key, or null if the key cannot be resolved.
     * @param key – the property name to resolve
     * @since 3.1.8-v6
     */
    public static String getStringPropertyValue(String key){
        return getPropertyValue(key, String.class, null);
    }

    public static String getStringPropertyValueWithDefault(String key, String defaultValue) {
        return getPropertyValue(key, String.class, defaultValue);
    }

    private static<T> T getPropertyValue(String key, Class<T> clazz, T defaultValue){
        checkIfNullThrowException();
        if (defaultValue != null) {
            return applicationContext.getEnvironment().getProperty(key, clazz, defaultValue);
        }
        return applicationContext.getEnvironment().getProperty(key, clazz);
    }


    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        log.info("spring context util initial success");
    }
}
