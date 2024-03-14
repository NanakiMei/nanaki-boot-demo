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
            try {
                Thread.sleep(1000 * 10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        public void initMethod() {
            System.out.println(Thread.currentThread().getName() + " ============ initMethod");
            try {
                Thread.sleep(1000 * 10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        public void destroyMethod() {
            System.out.println(Thread.currentThread().getName() + " ============ destroyMethod");
            try {
                Thread.sleep(1000 * 10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        @Override
        public void afterPropertiesSet() throws Exception {
            System.out.println(Thread.currentThread().getName() + " ============ DemoInitializingBean");
            try {
                Thread.sleep(1000 * 10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        @PostConstruct
        public void init() {
            System.out.println(Thread.currentThread().getName() + " ============ @PostConstruct");
            try {
                Thread.sleep(1000 * 10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        @PreDestroy
        public void preDestroy() {
            System.out.println(Thread.currentThread().getName() + " ============ @PreDestroy");
            try {
                Thread.sleep(1000 * 10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        @Override
        public void destroy() throws Exception {
            System.out.println(Thread.currentThread().getName() + " ============ DisposableBean");
            try {
                Thread.sleep(1000 * 10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        @Override
        public void run(ApplicationArguments args) throws Exception {
            System.out.println(Thread.currentThread().getName() + " ============ ApplicationRunner");
            try {
                Thread.sleep(1000 * 10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        @Override
        public void run(String... args) throws Exception {
            System.out.println(Thread.currentThread().getName() + " ============ CommandLineRunner");
            try {
                Thread.sleep(1000 * 10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
