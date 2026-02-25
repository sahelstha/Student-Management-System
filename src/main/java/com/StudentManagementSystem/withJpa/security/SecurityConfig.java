package com.StudentManagementSystem.withJpa.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(csrf-> csrf.disable())
                .authorizeHttpRequests(auth->
                        auth.anyRequest().authenticated())
                .httpBasic(Customizer.withDefaults())
                .headers(headers -> headers
                        .frameOptions(frame -> frame.disable()))   // allows /h2-console iframe
                .build();
    }
}
