package com.nanaki.common;

import cn.hutool.core.date.DateUtil;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author nanaki_1995@163.com
 * @description:
 * @date 2024/3/25
 */
public class TimeDemo {

    public static void main(String[] args) {
        while (true) {
            System.out.println(DateUtil.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
