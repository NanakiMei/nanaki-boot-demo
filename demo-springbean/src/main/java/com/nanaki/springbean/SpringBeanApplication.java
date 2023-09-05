package com.nanaki.springbean;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author nanaki_1995@163.com
 * @description:
 * @date 2023/9/4
 */
@SpringBootApplication
public class SpringBeanApplication {

    /**
     * Constructor > @PostConstruct > InitializingBean > init-method
     * @PreDestroy > DisposableBean > destroyMethod
     */
    public static void main(String[] args) {
        SpringApplication.run(SpringBeanApplication.class);
        System.out.println(
                "\n __   __   __   __  |__, o     |__   __   __  _|_  \n"
                        + "|  ) (__( |  ) (__( |  \\ |     |__) (__) (__)  |_, \n"
        );
    }
}
