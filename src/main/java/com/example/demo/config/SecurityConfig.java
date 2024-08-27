package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * @author ljy
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig{
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                //设置路径可被任何人访问
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/login").permitAll()
                //其他所有请求都需要经过身份验证
                        .anyRequest().authenticated()
                )
                .formLogin(formLogin -> formLogin
                //设置登录页面为
                        .loginPage("/login")
                )
                //设置记住我功能
                .rememberMe(Customizer.withDefaults());

        return http.build();
    }
}