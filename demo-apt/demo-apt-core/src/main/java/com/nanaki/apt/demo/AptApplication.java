package com.nanaki.apt.demo;

import com.nanaki.apt.processor.constants.AptConstant;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.IOException;
import java.util.Properties;

/**
 * @author nanaki_1995@163.com
 * @description:
 * @date 2023/9/15
 */
@SpringBootApplication
public class AptApplication {

    public static void main(String[] args) {
        SpringApplication.run(AptApplication.class);

        try {
            System.out.println("================");
            System.out.println(Apt1.class.getCanonicalName());
            System.out.println(Apt1.class.getSimpleName());

            Properties properties = PropertiesLoaderUtils.loadAllProperties(AptConstant.PROPERTIES_FILE);
            for (Object key : properties.keySet()) {
                System.out.println(key + "=" + properties.get(key));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(
                "\n __   __   __   __  |__, o     |__   __   __  _|_  \n"
                + "|  ) (__( |  ) (__( |  \\ |     |__) (__) (__)  |_, \n"
        );
    }
}
