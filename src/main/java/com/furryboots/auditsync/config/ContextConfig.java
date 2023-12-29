package com.furryboots.auditsync.config;

import com.furryboots.auditsync.data.domain.Context;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ContextConfig {

    @Value("${auditsync.batchSize}")
    private int batchSize;

    @Bean
    public Context context() {
        return new Context(batchSize);
    }
}
