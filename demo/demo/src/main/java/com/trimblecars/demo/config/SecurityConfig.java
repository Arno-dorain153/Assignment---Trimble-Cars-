//package com.trimblecars.demo.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
//import org.springframework.security.web.SecurityFilterChain;
//
//
//@Configuration
//public class SecurityConfig {
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .authorizeHttpRequests(auth -> auth.anyRequest().permitAll())
//                .csrf(AbstractHttpConfigurer::disable);
//        return http.build();
//    }
//}
//
//
//
//
////@Configuration
////@EnableWebSecurity
////public class SecurityConfig {
////    @Bean
////    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
////        http
////                .authorizeHttpRequests(auth -> auth
////                        .requestMatchers("/cars/**").authenticated()
////                        .anyRequest().permitAll()
////                )
////                // Comment out or remove this line temporarily to disable OAuth2 login
////                //.oauth2Login(Customizer.withDefaults())
////                .csrf(AbstractHttpConfigurer::disable);
////        return http.build();
////    }
////}
//
//
//
//
////@Configuration
////@EnableWebSecurity
////public class SecurityConfig {
////    @Bean
////    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
////        http
////                .authorizeHttpRequests(auth -> auth
////                        .requestMatchers("/cars/**").authenticated()
////                        .anyRequest().permitAll()
////                )
////                .oauth2Login(Customizer.withDefaults())
////                .csrf(AbstractHttpConfigurer::disable);
////        return http.build();
////    }
////
////}
////
//
