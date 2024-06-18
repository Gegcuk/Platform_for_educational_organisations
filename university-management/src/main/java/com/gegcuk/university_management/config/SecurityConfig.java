package com.gegcuk.university_management.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(authorizeRequests -> authorizeRequests
                .requestMatchers("/web/users/**").permitAll()
                .anyRequest().authenticated()
                )
            .formLogin(form -> form
                .loginPage("/login")
                .permitAll()
            )
            .httpBasic(withDefaults -> {});

        return http.build();
    }
}
