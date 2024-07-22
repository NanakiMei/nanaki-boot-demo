package com.nanaki.demo.event;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.EventListener;

import java.time.Clock;

/**
 * @author nanaki_1995@163.com
 * @description:
 * @date 2023/9/4
 */
@SpringBootApplication
public class SpringEventApplication implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        TestApplicationEvent testApplicationEvent = new TestApplicationEvent("a");
        System.out.println("init:" + testApplicationEvent.getSource());
        EventPublisher.getInstance().withEvent(testApplicationEvent).publish();

        TestApplicationEvent testApplicationEvent1 = new TestApplicationEvent("a1");
        EventPublisher.getInstance().withEvent(testApplicationEvent1).publish();
    }

    static class TestApplicationEvent extends ApplicationEvent {

        public TestApplicationEvent(Object source) {
            super(source);
        }

        public TestApplicationEvent(Object source, Clock clock) {
            super(source, clock);
        }
    }

    @EventListener
    public void listener1(TestApplicationEvent event) {
        System.out.println("listener1:" + event.getSource());
    }

    @EventListener
    public void listener2(TestApplicationEvent event) {
        System.out.println("listener2:" + event.getSource());
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringEventApplication.class);
        System.out.println(
                "\n __   __   __   __  |__, o     |__   __   __  _|_  \n"
                + "|  ) (__( |  ) (__( |  \\ |     |__) (__) (__)  |_, \n"
        );
    }

}
