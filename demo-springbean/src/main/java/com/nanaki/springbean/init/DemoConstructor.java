package com.nanaki.springbean.init;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author nanaki_1995@163.com
 * @description:
 * @date 2023/9/4
 */
@Component
public class DemoConstructor {

    @Value("${test:Constructor}")
    private String value;

    DemoConstructor() {
        System.out.println(Thread.currentThread().getName() + " ============ Constructor");
        try {
            Thread.sleep(1000 * 10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
