package com.example.demo.config;

import feign.Request;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfiguration {

    @Bean
    public Request.Options options() {
        return new Request.Options(10000, 90000);
    }

}