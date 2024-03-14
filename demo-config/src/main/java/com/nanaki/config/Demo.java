package com.nanaki.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author nanaki_1995@163.com
 * @description:
 * @date 2024/3/14
 */
@Component
public class Demo {

    /**
     * 华三默认 sn
     */
    @Value("${h3c.sn.type:3130A5Y4}")
    private String snType;
    /**
     * 紫光默认 sn
     */
    @Value("${h3c.sn.type:3130A5XN}")
    private String uniSnType;

    @PostConstruct
    public void init() {
        System.out.println(snType);
        System.out.println(uniSnType);
    }

}
