package com.nanaki.spi.google;

import com.nanaki.spi.demo.IJava2Spi;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ServiceLoader;

/**
 * @author nanaki_1995@163.com
 * @description:
 * @date 2023/10/13
 */
@Component
public class AutoDemo {

    @PostConstruct
    public void init() {
        System.out.println("=========== AutoDemo ==========");
        ServiceLoader<AutoApi> load = ServiceLoader.load(AutoApi.class);
        for (AutoApi autoApi : load) {
            String resource = autoApi.getResource();
            System.out.println("ServiceLoader resource: " + resource);
        }
    }

}
