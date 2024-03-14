package com.nanaki.mdc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author nanaki_1995@163.com
 * @description:
 * @date 2024/1/24
 */
@Configuration
public class ThreadPoolTaskExecutorConfig {

    //最大可用的CPU核数
    public static final int PROCESSORS = Runtime.getRuntime().availableProcessors();

    @Bean
    public ThreadPoolExecutorMdcWrapper getExecutor() {
        ThreadPoolExecutorMdcWrapper executor =new ThreadPoolExecutorMdcWrapper();
        executor.setCorePoolSize(PROCESSORS *2);
        executor.setMaxPoolSize(PROCESSORS * 4);
        executor.setQueueCapacity(50);
        executor.setKeepAliveSeconds(60);
        executor.setThreadNamePrefix("Task-A");
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());
        executor.initialize();
        return executor;
    }

}
