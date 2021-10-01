package com.somegroup.marketplace.config;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@Order(SecurityProperties.BASIC_AUTH_ORDER - 10)
@EnableWebSecurity
public class ApplicationConfigurerAdapter extends WebSecurityConfigurerAdapter {
    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    @Override
    public UserDetailsService userDetailsService() {

        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

        final User.UserBuilder userBuilder = User.builder().passwordEncoder(encoder::encode);
        UserDetails user = userBuilder
                .username("r3v1zor")
                .password("11111")
                .roles("ADMIN")
                .build();

        UserDetails admin = userBuilder
                .username("koteuko")
                .password("123")
                .roles("USER","ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user, admin);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/protected/**").access("hasRole('USER')")
                .antMatchers("/comicBook/**").access("hasRole('ADMIN')")
                .antMatchers("/comicBook").access("hasRole('ADMIN')")
                .antMatchers("/user/**").permitAll()
                .and().formLogin().defaultSuccessUrl("/", false);

    }

}