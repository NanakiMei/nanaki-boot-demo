package com.nanaki.mdc.config;

import com.nanaki.mdc.trace.TraceHolder;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;

/**
 * @author nanaki_1995@163.com
 * @description:
 * @date 2024/1/24
 */
public class ThreadPoolExecutorMdcWrapper extends ThreadPoolTaskExecutor {

    @Override
    public void execute(Runnable task) {
        super.execute(TraceHolder.wrap(task));
    }

    @Override
    public Future<?> submit(Runnable task) {
        return super.submit(TraceHolder.wrap(task));
    }

    @Override
    public <T> Future<T> submit(Callable<T> task) {
        return super.submit(TraceHolder.wrap(task));
    }
}
