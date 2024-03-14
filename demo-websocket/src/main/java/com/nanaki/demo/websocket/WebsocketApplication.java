package com.nanaki.demo.websocket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.socket.config.annotation.EnableWebSocket;

/**
 * @author nanaki_1995@163.com
 * @description:
 * @date 2023/9/4
 */
@EnableScheduling
@EnableWebSocket
@SpringBootApplication
public class WebsocketApplication {

    /**
     * Constructor > @PostConstruct > InitializingBean > init-method > ApplicationRunner > CommandLineRunner
     * @PreDestroy > DisposableBean > destroyMethod
     */
    public static void main(String[] args) {
        SpringApplication.run(WebsocketApplication.class);
        System.out.println(
                "\n __   __   __   __  |__, o     |__   __   __  _|_  \n"
                + "|  ) (__( |  ) (__( |  \\ |     |__) (__) (__)  |_, \n"
        );
    }
}
