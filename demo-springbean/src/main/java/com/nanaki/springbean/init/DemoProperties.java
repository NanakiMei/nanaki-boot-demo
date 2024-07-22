package com.nanaki.springbean.init;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author nanaki_1995@163.com
 * @description:
 * @date 2024/6/4
 */
@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "test")
public class DemoProperties {

    private String value = "DemoProperties";

    public DemoProperties() {
        System.out.println("before:" + value);
        this.value = "DemoProperties.Constructor";
        System.out.println("after:" + value);
    }

}
