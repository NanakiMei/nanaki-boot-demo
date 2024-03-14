package com.nanaki.springbean.task;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author nanaki_1995@163.com
 * @description:
 * @date 2024/1/18
 */
@EnableScheduling
@Component
public class Task {

    @Scheduled(fixedDelay = 1 * 1000)
    public void test1() {
        System.out.println("test1" + " " + Thread.currentThread().getId() + ":" +Thread.currentThread().getName());
    }

    @Scheduled(fixedDelay = 1 * 1000)
    public void test2() {
        System.out.println("test2" + " " + Thread.currentThread().getId() + ":" +Thread.currentThread().getName());
    }

    @Scheduled(fixedDelay = 1 * 1000)
    public void test3() {
        System.out.println("test3" + " " + Thread.currentThread().getId() + ":" +Thread.currentThread().getName());
    }

}
