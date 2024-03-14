package com.nanaki.mdc.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author nanaki_1995@163.com
 * @description:
 * @date 2024/1/18
 */
@Slf4j
@EnableScheduling
@Component
public class Task {

    @Scheduled(fixedDelay = 1 * 1000)
    public void test1() {
        log.info("test1");
        System.out.println("test1" + " " + Thread.currentThread().getId() + ":" +Thread.currentThread().getName());
    }

    @Scheduled(fixedDelay = 1 * 1000)
    public void test2() {
        log.info("test2");
        System.out.println("test2" + " " + Thread.currentThread().getId() + ":" +Thread.currentThread().getName());
    }

    @Scheduled(fixedDelay = 1 * 1000)
    public void test3() {
        log.info("test3");
        new Thread(() -> {
            log.info("test3-thread");
            System.out.println("test3-thread" + " " + Thread.currentThread().getId() + ":" +Thread.currentThread().getName());
        });
        System.out.println("test3" + " " + Thread.currentThread().getId() + ":" +Thread.currentThread().getName());
    }

}
