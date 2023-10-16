package com.nanaki.springbean.init;

/**
 * @author nanaki_1995@163.com
 * @description:
 * @date 2023/9/4
 */

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
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


    class Demo implements InitializingBean, DisposableBean, ApplicationRunner, CommandLineRunner {

        Demo() {
            System.out.println(Thread.currentThread().getName() + " ============ @Bean");
        }

        public void initMethod() {
            System.out.println(Thread.currentThread().getName() + " ============ initMethod");
        }

        public void destroyMethod() {
            System.out.println(Thread.currentThread().getName() + " ============ destroyMethod");
        }

        @Override
        public void afterPropertiesSet() throws Exception {
            System.out.println(Thread.currentThread().getName() + " ============ DemoInitializingBean");
        }

        @PostConstruct
        public void init() {
            System.out.println(Thread.currentThread().getName() + " ============ @PostConstruct");
        }

        @PreDestroy
        public void preDestroy() {
            System.out.println(Thread.currentThread().getName() + " ============ @PreDestroy");
        }

        @Override
        public void destroy() throws Exception {
            System.out.println(Thread.currentThread().getName() + " ============ DisposableBean");
        }

        @Override
        public void run(ApplicationArguments args) throws Exception {
            System.out.println(Thread.currentThread().getName() + " ============ ApplicationRunner");
        }

        @Override
        public void run(String... args) throws Exception {
            System.out.println(Thread.currentThread().getName() + " ============ CommandLineRunner");
        }
    }

}
