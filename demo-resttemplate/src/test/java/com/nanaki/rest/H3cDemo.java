package com.nanaki.rest;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.client.LaxRedirectStrategy;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.apache.http.ssl.SSLContexts;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.SSLContext;
import java.util.ArrayList;
import java.util.List;

/**
 * @author nanaki_1995@163.com
 * @description:
 * @date 2023/12/8
 */
public class H3cDemo {

    public static void main(String[] args) throws Exception {
        RestTemplate restTemplate = restTemplate();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("username", "admin");
        jsonObject.put("password", "Admin@123");
        ResponseEntity<JSONObject> jsonObjectResponseEntity = restTemplate.postForEntity("https://172.16.44.210:8441/api/h3c/auth/v1/apikey", jsonObject, JSONObject.class);
        System.out.println(jsonObjectResponseEntity.getBody());
    }

    public static RestTemplate restTemplate() throws Exception {

        SSLContext sslContext = SSLContexts.custom().loadTrustMaterial(null, (x509Certificates, authType) -> true).build();
        SSLConnectionSocketFactory sslConnectionSocketFactory = new SSLConnectionSocketFactory(sslContext, NoopHostnameVerifier.INSTANCE);

        RegistryBuilder<ConnectionSocketFactory> builder = RegistryBuilder.create();
        builder.register("http", PlainConnectionSocketFactory.getSocketFactory());
        builder.register("https", sslConnectionSocketFactory);
        Registry<ConnectionSocketFactory> socketFactoryRegistry = builder.build();
        PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager(socketFactoryRegistry);
        connectionManager.setMaxTotal(1000);
        connectionManager.setDefaultMaxPerRoute(1000);
        BasicHeader header = new BasicHeader(HTTP.CONN_DIRECTIVE, HTTP.CONN_CLOSE);
        List<BasicHeader> headers = new ArrayList<>();
        headers.add(header);
        CloseableHttpClient httpclient = HttpClients.custom().setConnectionManager(connectionManager)// 支持服务器内302重定向
                .setRedirectStrategy(new LaxRedirectStrategy()).setDefaultHeaders(headers).build();
        HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory(httpclient);
        requestFactory.setConnectTimeout(15000);
        requestFactory.setConnectionRequestTimeout(15000);
        return new RestTemplate(requestFactory);
    }

}
