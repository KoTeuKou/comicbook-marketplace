package com.somegroup.marketplace.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.userdetails.MapReactiveUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
public class ApplicationConfigurerAdapter {
    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
        return http.authorizeExchange()
                .pathMatchers("/protected/**").hasRole("ADMIN")
                .pathMatchers("/comicBook/**").hasRole("ADMIN")
                .pathMatchers("/comicBook").hasRole("ADMIN")
                .pathMatchers("/user/**").permitAll()
                .pathMatchers("/user/register").hasRole("ADMIN")
                .anyExchange()
                .authenticated()
                .and()
                .csrf().disable() // TODO: enable in future version
                .build();
    }

    @Bean
    public MapReactiveUserDetailsService userDetailsService() {
        UserDetails user1 = User
                .withUsername("r3v1zor")
                .password("11111")
                .roles("USER", "ADMIN")
                .build();

        UserDetails user2 = User
                .withUsername("koteuko")
                .password("123")
                .roles("USER", "ADMIN")
                .build();

        return new MapReactiveUserDetailsService(user1, user2);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}