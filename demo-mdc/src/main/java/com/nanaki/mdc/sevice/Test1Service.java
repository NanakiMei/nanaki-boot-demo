package com.nanaki.mdc.sevice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author nanaki_1995@163.com
 * @description:
 * @date 2024/1/24
 */
@Slf4j
@Service
public class Test1Service {

    public void test1() {
        log.info("Test1Service.info:test1");
        log.warn("Test1Service.warn:test1");
        log.error("Test1Service.error:test1");
    }

}
