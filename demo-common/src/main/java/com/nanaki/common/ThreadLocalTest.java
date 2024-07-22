package com.nanaki.common;

import org.junit.Test;
import org.springframework.context.ApplicationEvent;

import java.util.ArrayList;
import java.util.List;

/**
 * @author nanaki_1995@163.com
 * @description:
 * @date 2024/7/22
 */
public class ThreadLocalTest {

    private final ThreadLocal<List<String>> threadLocal = new ThreadLocal<List<String>>() {
        @Override
        protected List<String> initialValue() {
            // 使用线程安全的 CopyOnWriteArrayList 以支持并发的 add 操作
            return new ArrayList<>();
        }

        // 在适当的时候清理 ThreadLocal 变量存储的值，以避免内存泄露
        @Override
        public void remove() {
            super.remove();
            // 也可以在这里添加额外的资源清理逻辑，比如日志记录等
        }
    };

    @Test
    public void test() {
        List<String> eventList = threadLocal.get();
        System.out.println(eventList);
        eventList.add("a");
        System.out.println(eventList);
        threadLocal.remove();
        System.out.println(threadLocal.get());
    }

}
