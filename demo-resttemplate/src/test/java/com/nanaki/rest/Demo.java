package com.nanaki.rest;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 * @author nanaki_1995@163.com
 * @description:
 * @date 2023/9/15
 */
public class Demo {

    public static void main(String[] args) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization", "basic Y2xpZW50OmNsaWVudHB3ZA==");
        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);


        HttpEntity<JSONObject> entity = new HttpEntity<>(httpHeaders);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<JSONObject> exchange = restTemplate.exchange("http://172.16.44.211:8080/liccmgr/api/v1/oauth2/token?scope=all&grant_type=password&username=apiadmin&password=apiadmin@h3c", HttpMethod.POST, entity, JSONObject.class);
        System.out.println(JSON.toJSONString(exchange.getBody()));
    }

}
