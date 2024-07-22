package com.nanaki.springbean.init;

/**
 * @author nanaki_1995@163.com
 * @description:
 * @date 2023/9/4
 */

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

@Configuration
public class DemoBeanConfig {

    @Resource
    private DemoProperties demoProperties;

    @Bean(initMethod = "initMethod", destroyMethod = "destroyMethod")
    public Demo demo() {
        System.out.println("@Bean:" + demoProperties.getValue());
        demoProperties.setValue("@Bean");
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
            System.out.println("initMethod:" + demoProperties.getValue());
            demoProperties.setValue("initMethod");
            System.out.println(Thread.currentThread().getName() + " ============ initMethod");
            try {
                Thread.sleep(1000 * 10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        public void destroyMethod() {
            System.out.println("destroyMethod:" + demoProperties.getValue());
            demoProperties.setValue("destroyMethod");
            System.out.println(Thread.currentThread().getName() + " ============ destroyMethod");
            try {
                Thread.sleep(1000 * 10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        @Override
        public void afterPropertiesSet() throws Exception {
            System.out.println("InitializingBean:" + demoProperties.getValue());
            demoProperties.setValue("InitializingBean");
            System.out.println(Thread.currentThread().getName() + " ============ InitializingBean");
            try {
                Thread.sleep(1000 * 10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        @PostConstruct
        public void init() {
            System.out.println("@PostConstruct:" + demoProperties.getValue());
            demoProperties.setValue("@PostConstruct");
            System.out.println(Thread.currentThread().getName() + " ============ @PostConstruct");
            try {
                Thread.sleep(1000 * 10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        @PreDestroy
        public void preDestroy() {
            System.out.println("@PreDestroy:" + demoProperties.getValue());
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
