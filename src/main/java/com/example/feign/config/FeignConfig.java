package com.example.feign.config;

import com.example.feign.feign.logger.FeignCustomLogger;
import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {

    //global 설정으로 만든다.
    @Bean
    public Logger feinLogger() {
        return new FeignCustomLogger();
    }

}
