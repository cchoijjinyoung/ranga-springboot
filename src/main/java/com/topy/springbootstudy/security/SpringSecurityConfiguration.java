package com.topy.springbootstudy.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.*;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // 1) All requests should be authenticated
        // 1) 모든 요청이 인증되어야함
        http.authorizeHttpRequests(
                auth -> auth.anyRequest().authenticated()
        );
        // => 이 페이지를 볼 수 있는 권한이 없습니다. HTTP ERROR 403
        // 하지만, REST API의 경우 기본 인증을 사용 설정할 수 있다.
        http.httpBasic(withDefaults());
        // => 로그인 팝업 창(사용자이름, 비밀번호)
        http.csrf().disable();
        // 2) If a request is not authenticated, a web page is shown
        // 2)
        // 3) CSRF -> POST, PUT
        // 3)



        return http.build();
    }
}
