package com.nanaki.demo.websocket;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author nanaki_1995@163.com
 * @description:
 * @date 2024/3/14
 */
@Slf4j
@ServerEndpoint(value = "/message/ws/{param}")
@Component
public class CommonMessageWebSocket {

    private static volatile ConcurrentHashMap<String, Session> sessionMap = new ConcurrentHashMap<>();

    /**
     * 连接成功
     */
    @OnOpen
    public void onOpen(Session session, @PathParam("param") String param) {
        log.info("onOpen; sessionId:{} param:{}", session.getId(), param);
        sessionMap.put(param, session);
    }

    /**
     * 连接关闭
     */
    @OnClose
    public void onClose(Session session, @PathParam("param") String param) {
        log.info("onClose; sessionId:{} param:{}", session.getId(), param);
        sessionMap.remove(param);
    }

    /**
     * 收到客户端消息
     */
    @OnMessage
    public void onMessage(String message, Session session, @PathParam("param") String param) {
        log.info("onMessage; sessionId:{} message:{} param:{}", session.getId(), message, param);
    }

    /**
     * 发生错误
     */
    @OnError
    public void onError(Session session, Throwable error, @PathParam("param") String param) {
        log.info("onError; sessionId:{} param:{} error:{}", session.getId(), param, error.getMessage());
    }


    @Scheduled(fixedDelay = 1000)
    public void job() throws IOException {
        if (sessionMap.isEmpty()) {
            return;
        }
        for (Map.Entry<String, Session> entry : sessionMap.entrySet()) {
            Session session = entry.getValue();
            session.getBasicRemote().sendText(String.valueOf(System.currentTimeMillis()));
        }
    }


    private static Map<String, List<String>> map = new HashMap<>();

    public static void main(String[] args) {
        List<String> a = map.get("a");
        if (Objects.isNull(a)) {
            List<String> list = new ArrayList<>();
            list.add("a");
            map.put("a", list);
        }
        System.out.println(map);

        List<String> a2 = map.get("a");
        a2.add("b");
        System.out.println(map);

        map.put("b", a2);
        System.out.println(map);
    }

}
