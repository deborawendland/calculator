package com.deborawendland.cloud.tema08.config;

import com.deborawendland.cloud.tema08.rxNetty.HealthCheckResource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages =  "com.deborawendland.cloud.tema08")
public class HealthCheckConfig {

    @Bean
    public HealthCheckResource healthCheckResource(){
        return new HealthCheckResource();
    }
}
