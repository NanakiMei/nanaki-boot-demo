package com.nanaki.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author nanaki_1995@163.com
 * @description:
 * @date 2023/9/26
 */
@Component
@EnableScheduling
@ConditionalOnProperty(name = "nanaki.test1.enabled", havingValue = "true")
public class ConditionalOnPropertyTest1 {

    @Scheduled(cron = "*/5 * * * * ?")
    public void test(){
        System.out.println("========== ConditionalOnPropertyTest1");
    }

}
