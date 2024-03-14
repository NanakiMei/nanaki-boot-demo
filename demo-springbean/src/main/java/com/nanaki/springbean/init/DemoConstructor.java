package com.nanaki.springbean.init;

import org.springframework.stereotype.Component;

/**
 * @author nanaki_1995@163.com
 * @description:
 * @date 2023/9/4
 */
@Component
public class DemoConstructor {

    DemoConstructor() {
        System.out.println(Thread.currentThread().getName() + " ============ Constructor");
        try {
            Thread.sleep(1000 * 10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
