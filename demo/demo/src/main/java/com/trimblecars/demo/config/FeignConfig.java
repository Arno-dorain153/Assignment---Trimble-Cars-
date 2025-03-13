//package com.trimblecars.demo.config;
//
//import feign.Logger;
//import feign.Request;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class FeignConfig {
//
//    @Value("${feign.client.config.default.loggerLevel:FULL}")
//    private String loggerLevel;
//
//    @Bean
//    public Logger.Level feignLoggerLevel() {
//        return Logger.Level.valueOf(loggerLevel);
//    }
//
//    @Bean
//    public Request.Options feignOptions() {
//        return new Request.Options(5000, 10000);  // 5 seconds connection timeout, 10 seconds read timeout
//    }
//}
//
