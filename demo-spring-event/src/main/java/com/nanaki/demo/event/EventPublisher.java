package com.nanaki.demo.event;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 事件发布工具类，不支持多线程并发访问
 * @author wkang
 * @date 2024/5/17
 * @since feature_3.1.8_R506.P001
 */
@Slf4j
@Component
@Lazy(value = false)
public class EventPublisher implements ApplicationEventPublisherAware {

    private final ThreadLocal<List<ApplicationEvent>> event_threadLocal = new ThreadLocal<List<ApplicationEvent>>() {
        @Override
        protected List<ApplicationEvent> initialValue() {
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

    private ApplicationEventPublisher publisher;

    public static EventPublisher getInstance() {
        return SpringContextUtil.getBean(EventPublisher.class);
    }


    public EventPublisher withEvent(ApplicationEvent event) {
        if (Objects.isNull(event)) {
            return this;
        }
        List<ApplicationEvent> eventList = event_threadLocal.get();
        eventList.add(event);
        return this;
    }

    public void publish() {
        try {
            for (ApplicationEvent event : event_threadLocal.get()) {
                log.info("[GBC|EventPublisher] Publish event [{}] {}", event.getClass().getName()
                        , Objects.isNull(event.getSource()) ? "" : JSONObject.toJSONString(event.getSource()));
                publisher.publishEvent(event);
            }
        } catch (Exception e) {
            List<ApplicationEvent> eventList = event_threadLocal.get();
            log.error("publish event[{}] error", eventList == null ? null : JSON.toJSONString(eventList), e);
        } finally {
            //reset
            event_threadLocal.remove();
        }

    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        publisher = applicationEventPublisher;
    }
}
