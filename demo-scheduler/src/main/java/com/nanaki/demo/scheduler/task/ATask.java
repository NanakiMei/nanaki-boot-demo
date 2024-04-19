package com.nanaki.demo.scheduler.task;

import cn.hutool.core.date.DateUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author nanaki_1995@163.com
 * @description:
 * @date 2024/3/25
 */
@Component
public class ATask {

    @Scheduled(cron = "0 */1 * * * ?")
    public void cron1() {
        String date = DateUtil.format(new Date(), "yyyy-MM-dd HH:mm:ss");
        System.out.println(date + " ======cron1");
    }

    @Scheduled(cron = "0 0/1 * * * ?")
    public void cron2() {
        String date = DateUtil.format(new Date(), "yyyy-MM-dd HH:mm:ss");
        System.out.println(date + " ======cron2");
    }

    @Scheduled(fixedDelay = 10 * 1000)
    public void fixedDelay() {
        String date = DateUtil.format(new Date(), "yyyy-MM-dd HH:mm:ss");
        System.out.println(date + " ======fixedDelay");
    }

    @Scheduled(fixedRate = 10 * 1000)
    public void fixedRate() {
        String date = DateUtil.format(new Date(), "yyyy-MM-dd HH:mm:ss");
        System.out.println(date + " ======fixedRate");
    }

}
