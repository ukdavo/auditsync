package com.furryboots.auditsync.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
public class ThreadConfig {

    @Value("${auditsync.terminationWaitTimeSecs}")
    private int terminationWaitTimeSecs;

    @Bean("syncTaskExecutor")
    public TaskExecutor taskExecutor() {
        final ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(1);
        executor.setMaxPoolSize(1);
        executor.setThreadNamePrefix("auditsync_processor_thread");
        executor.setAwaitTerminationSeconds(terminationWaitTimeSecs);
        executor.initialize();
        return executor;
    }

}
