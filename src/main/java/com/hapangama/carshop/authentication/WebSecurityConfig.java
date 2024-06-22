package com.hapangama.carshop.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;


//https://stackoverflow.com/questions/73107059/disable-csrf-cors-in-spring-boot-spring-security-5-7-and-saml
@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

//    @Autowired
//    private UserService userService;
//
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userService).passwordEncoder(bCryptPasswordEncoder());
//    }
//    @Bean
//    public BCryptPasswordEncoder bCryptPasswordEncoder() {
//        return new BCryptPasswordEncoder();
//    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {


        //disable csrf
        return http.csrf(csrf -> csrf.disable()).build();

    }

//    @Bean
//    public CorsConfigurationSource corsConfigurationSource() {
//        var configuration = new CorsConfiguration();
//        configuration.setAllowedOrigins(List.of("*")); // Access-Control-Allow-Origin
//        configuration.setAllowedMethods(List.of("*")); // Access-Control-Allow-Methods
//        configuration.setAllowedHeaders(List.of("*")); // Access-Control-Allow-Headers
//        configuration.setAllowCredentials(true); // Access-Control-Allow-Credentials
//        configuration.setMaxAge((long) 60 * 60 * 24);
//        var source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", configuration);
//
//        return source;
//    }
}