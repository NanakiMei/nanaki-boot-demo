package com.nanaki.mdc.interceptor;

import com.nanaki.mdc.constants.LogConstants;
import com.nanaki.mdc.trace.TraceHolder;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author nanaki_1995@163.com
 * @description:
 * @date 2024/1/24
 */
@Component
public class TraceInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String traceId = request.getHeader(LogConstants.WEB_TRACE_ID);
        if (StringUtils.isBlank(traceId)) {
            TraceHolder.setTraceIdIfAbsent();
        } else {
            TraceHolder.setTraceId(traceId);
        }

        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        TraceHolder.removeTraceId();
    }

    public static void main(String[] args) {
        ProcessBuilder builder = new ProcessBuilder();
        builder.command("ifconfig", "-l;ll");
        try {
            Process process = builder.start();
//            Process process = Runtime.getRuntime().exec(new String[]{"sh", "-c", "ifconfig -l;ll"});

            BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line = null;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            int resultCode = process.waitFor();
            System.out.println(resultCode);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
