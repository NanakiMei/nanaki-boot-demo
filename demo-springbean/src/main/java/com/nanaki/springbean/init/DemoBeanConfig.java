package com.nanaki.springbean.init;

/**
 * @author nanaki_1995@163.com
 * @description:
 * @date 2023/9/4
 */

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Configuration
public class DemoBeanConfig {

    @Bean(initMethod = "initMethod", destroyMethod = "destroyMethod")
    public Demo demo() {
        return new Demo();
    }


    class Demo implements InitializingBean, DisposableBean {

        Demo() {
            System.out.println("============ @Bean");
        }

        public void initMethod() {
            System.out.println("============ initMethod");
        }

        public void destroyMethod() {
            System.out.println("============ destroyMethod");
        }

        @Override
        public void afterPropertiesSet() throws Exception {
            System.out.println("============ DemoInitializingBean");
        }

        @PostConstruct
        public void init() {
            System.out.println("============ @PostConstruct");
        }

        @PreDestroy
        public void preDestroy() {
            System.out.println("============ @PreDestroy");
        }

        @Override
        public void destroy() throws Exception {
            System.out.println("============ DisposableBean");
        }
    }

}
