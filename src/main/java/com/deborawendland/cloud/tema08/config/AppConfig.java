package com.deborawendland.cloud.tema08.config;

import com.deborawendland.cloud.tema08.service.Calculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages =  "com.deborawendland.cloud.tema08")
public class AppConfig {

    @Bean
    public Calculator calculator() {
        return new Calculator();
    }
}
