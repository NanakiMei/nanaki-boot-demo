package com.nanaki.common;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * @author nanaki_1995@163.com
 * @description:
 * @date 2024/6/4
 */
public class SynchronizeDemo {

    @Test
    public void test01() throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            String lock = new StringBuilder("LOCK_").append(i).toString();
            System.out.println("lock: " + lock);
            synchronized (lock) {
                System.out.println(i);
                TimeUnit.SECONDS.sleep(5);
            }
        }
    }

    @Test
    public void test02() {
        String number = "123";
        test02(number);
        System.out.println(number);
    }

    private void test02(String text) {
        text = text + "+";
    }

}
