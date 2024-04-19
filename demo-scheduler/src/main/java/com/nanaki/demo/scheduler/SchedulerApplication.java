package com.nanaki.demo.scheduler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author nanaki_1995@163.com
 * @description:
 * @date 2024/3/25
 */
@EnableScheduling
@SpringBootApplication
public class SchedulerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SchedulerApplication.class);
        System.out.println(
                "\n __   __   __   __  |__, o     |__   __   __  _|_  \n"
                        + "|  ) (__( |  ) (__( |  \\ |     |__) (__) (__)  |_, \n"
        );
    }

}
