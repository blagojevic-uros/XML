package com.vacc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import util.ObjectParser;

@Configuration
@EnableAsync
public class AppConfig {
    @Bean
    public ObjectParser objectParser(){
        return new ObjectParser();
    }
}
