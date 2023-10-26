package com.example.schoolmanagementsystem;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@EnableWebSecurity
@Configuration
public class SecurityConfiguration {
    @Bean
    public SecurityFilterChain configure(HttpSecurity http)
        throws Exception {
        http.csrf().disable()
        .authorizeHttpRequests()
        .requestMatchers("/dashbords/**", "/parents/**")
        .permitAll().anyRequest()
        .authenticated()
        .and()
        .httpBasic();

        return http.build();

    }

    // Role Based Autherization 
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService users(){
        UserDetails user1 = User.builder()
        .username("nikhil")
        .password(passwordEncoder().encode("abc@123"))
        .build();

        UserDetails user2 = User.builder()
        .username("solomon")
        .password(passwordEncoder().encode("xyz@123"))
        .build();

        return new InMemoryUserDetailsManager(user1,user2);
    }
}
