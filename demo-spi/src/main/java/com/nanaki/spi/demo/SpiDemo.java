package com.nanaki.spi.demo;

import org.springframework.core.io.support.SpringFactoriesLoader;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.ServiceLoader;

/**
 * @author nanaki_1995@163.com
 * @description:
 * @date 2023/9/26
 */
@Component
public class SpiDemo {

    @PostConstruct
    public void init() {
        System.out.println("================= IJavaSpi");

        // ServiceLoader 读取 java.util.ServiceLoader.PREFIX 下配置
        // 参考 resources/META-INF/services/com.nanaki.spi.demo.IJavaSpi
        ServiceLoader<IJavaSpi> load = ServiceLoader.load(IJavaSpi.class);
        for (IJavaSpi iJavaSpi : load) {
            String resource = iJavaSpi.getResource();
            System.out.println("ServiceLoader resource: " + resource);
        }

        System.out.println("================= IJava2Spi");

        // 无实现测试，不会npe，返回的是空集合
        ServiceLoader<IJava2Spi> load2 = ServiceLoader.load(IJava2Spi.class);
        for (IJava2Spi iJavaSpi : load2) {
            String resource = iJavaSpi.getResource();
            System.out.println("ServiceLoader resource: " + resource);
        }

        System.out.println("================= ISpringSpi");

        // SpringFactoriesLoader 读取 org.springframework.core.io.support.SpringFactoriesLoader.FACTORIES_RESOURCE_LOCATION 找到实现类
        // 参考 resources/META-INF/spring.factories
        List<ISpringSpi> springSpis = SpringFactoriesLoader.loadFactories(ISpringSpi.class, Thread.currentThread().getContextClassLoader());
        for (ISpringSpi springSpi : springSpis) {
            String resource = springSpi.getResource();
            System.out.println("SpringFactoriesLoader resource: " + resource);
        }

    }

}
