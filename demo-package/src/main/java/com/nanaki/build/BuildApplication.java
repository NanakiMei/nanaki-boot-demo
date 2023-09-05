package com.nanaki.build;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author nanaki_1995@163.com
 * @description:
 * @date 2023/8/14
 */
@SpringBootApplication
public class BuildApplication {

    public static void main(String[] args) {
        SpringApplication.run(BuildApplication.class);
        System.out.println(
                "\n __   __   __   __  |__, o     |__   __   __  _|_  \n"
                + "|  ) (__( |  ) (__( |  \\ |     |__) (__) (__)  |_, \n"
        );
    }

}
