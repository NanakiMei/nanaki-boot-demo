package com.nanaki.mdc.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author nanaki_1995@163.com
 * @description:
 * @date 2024/1/24
 */
@Slf4j
@RestController
public class TestController {

    @GetMapping("test1")
    public void test1() {
        log.info("info:test1");
        log.warn("warn:test1");
        log.error("error:test1");
    }

}
