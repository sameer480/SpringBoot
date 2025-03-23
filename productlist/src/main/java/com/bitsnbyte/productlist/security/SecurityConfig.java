package com.bitsnbyte.productlist.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(csrf -> csrf.disable()) // Disable CSRF protection (not recommended for production APIs)
                .authorizeHttpRequests(request -> {
                    request.requestMatchers(HttpMethod.GET, "/api/**").permitAll(); // Allow GET requests to /api/**
                    request.anyRequest().authenticated(); // All other requests require authentication
                }).httpBasic(Customizer.withDefaults())
                .build(); // Return the configured SecurityFilterChain
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails admin= User.builder()
                .username("admin")
                .password(passwordEncoder().encode("admin"))
                .roles("ADMIN")
                .build();
        UserDetails seller= User.builder()
                .username(passwordEncoder().encode("seller"))
                .password("pasword")
                .roles("SELLER")
                .build();
        return new InMemoryUserDetailsManager(admin,seller);

    }
}
