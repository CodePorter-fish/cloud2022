package com.xq.springcloud.bean;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {

    @Bean
    Logger.Level feignLoggerLevel(){
        /**
         * NONE：默认，不显示任何日志
         * BASIC:仅记录请求方法，url，响应状态码及执行时间
         * HEADERS:除了BASIC中定义的信息外，还有请求和响应头的信息
         * FULL:除了上诉信息，还有请求响应的正文及元数据
         */
        return Logger.Level.FULL;
    }
}