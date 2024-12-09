package com.gcash.movie.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(csrf -> csrf.disable()) // Disable CSRF protection
                .headers(headers -> headers.frameOptions(frameOptions -> frameOptions.sameOrigin())) // Allow frames from the same origin
                .authorizeHttpRequests(auth -> {
                    auth.requestMatchers("/h2-console/**").permitAll(); // Whitelist H2 console
                    auth.anyRequest().authenticated(); // Require authentication for other paths
                })
                .oauth2Login(withDefaults()) // Enable OAuth2 login
                .formLogin(withDefaults()) // Enable form-based login
                .build();
    }

}