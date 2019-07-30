package com.wj.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author jun.wang
 * @title: FeignClientConfig
 * @projectName ownerpro
 * @description: TODO
 * @date 2019/7/30 16:10
 */

@Configuration
public class FeignClientConfig {


    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

    @Bean
    Logger feignInfoLogger(){
        return new FeignLogger();
    }
}
