//
//package com.jpaspring.hibernate.onetomany.utils;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configurers.HttpBasicConfigurer;
//import org.springframework.security.web.SecurityFilterChain;
//
///**
// * Author: Randjith
// * Created on @ 1 Nov 2023
// */
//@Configuration
//@EnableWebSecurity
//public class AppSecurityConfig  {
//
//	public AppSecurityConfig() {
//		// TODO Auto-generated constructor stub
//	}
//
//	public AppSecurityConfig(boolean disableDefaults) {
//		// TODO Auto-generated constructor stub
//	}
//	
//	@Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http
//            .authorizeHttpRequests((authz) -> authz
//                .anyRequest().authenticated()
//            )
//            .httpBasic(withDefaults());
//        return http.build();
//    }
//
//	private Customizer<HttpBasicConfigurer<HttpSecurity>> withDefaults() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//
//}
//
