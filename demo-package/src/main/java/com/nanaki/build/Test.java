package com.nanaki.build;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author nanaki_1995@163.com
 * @description:
 * @date 2023/9/11
 */
@Component
public class Test {

    @Value("${test}")
    private static String test;
    @Value("${test1}")
    private static String test1;
    @Value("${spring.profiles.active}")
    private static String profile;

    @PostConstruct
    public void init() {
        System.out.println(test);
        System.out.println(test1);
        System.out.println(profile);
    }

}
