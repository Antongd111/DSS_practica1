package com.example.demo;

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
	            .requestMatchers("/h2-console/**").permitAll()
	            .requestMatchers("/products/**").permitAll()
	            .anyRequest().authenticated() 
	        )
	        .formLogin(formLogin -> formLogin
	            .permitAll()
	        )
	        .logout(logout -> logout
	            .permitAll()
	        );

	    http.csrf().disable();
	    http.headers().frameOptions().disable();

	    return http.build();
	}
}