package com.acapa.ecoturismo.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.security.web.SecurityFilterChain;
import com.acapa.ecoturismo.repository.security.CustomUserDetailsService;

import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
    @Autowired
    private CustomUserDetailsService userDetailsService;
    @Autowired
   

//.httpBasic()
//
    @Bean
    SecurityFilterChain filterchain(HttpSecurity http, AuthenticationManager authManager) throws Exception {
        return http.csrf().disable()
        .authorizeHttpRequests().requestMatchers(HttpMethod.GET, "/api/**")
                .permitAll().requestMatchers("/api/auth/**").permitAll().anyRequest().authenticated()
                .and().httpBasic().and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).
                and().build();



    }

    @Bean
    AuthenticationManager authMananger(HttpSecurity http) throws Exception {
        return http.getSharedObject(AuthenticationManagerBuilder.class).userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder()).and().build();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}