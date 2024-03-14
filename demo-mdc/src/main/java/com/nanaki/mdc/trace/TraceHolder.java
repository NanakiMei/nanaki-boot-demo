package com.nanaki.mdc.trace;

import com.nanaki.mdc.constants.LogConstants;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.MDC;

import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.Callable;

/**
 * @author nanaki_1995@163.com
 * @description:
 * @date 2024/1/24
 */
public class TraceHolder {

    public static void setTraceIdIfAbsent() {
        if (StringUtils.isNotBlank(getTraceId())) {
            return;
        }

        String traceId = UUID.randomUUID().toString().replace("-", "");

        MDC.put(LogConstants.TRACE_ID, traceId);
    }

    public static void setTraceId(String traceId) {
        MDC.put(LogConstants.TRACE_ID, traceId);
    }

    public static String getTraceId() {
        return MDC.get(LogConstants.TRACE_ID);
    }

    public static void removeTraceId() {
        MDC.remove(LogConstants.TRACE_ID);
    }

    public static Runnable wrap(final Runnable runnable) {
        Map<String, String> contextMap = MDC.getCopyOfContextMap();

        return () -> {
            if (Objects.isNull(contextMap)) {
                MDC.clear();
            } else {
                MDC.setContextMap(contextMap);
            }

            setTraceIdIfAbsent();
            try {
                runnable.run();
            } finally {
                removeTraceId();
            }
        };
    }

    public static <T> Callable<T> wrap(final Callable<T> callable) {
        Map<String, String> contextMap = MDC.getCopyOfContextMap();

        return () -> {
            if (Objects.isNull(contextMap)) {
                MDC.clear();
            } else {
                MDC.setContextMap(contextMap);
            }

            setTraceIdIfAbsent();
            try {
                return callable.call();
            } finally {
                removeTraceId();
            }
        };
    }

}
