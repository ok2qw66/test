package com.test.book.springboot.config.auth;

import com.test.book.springboot.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity // Spring Security 설정 활성화
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().headers().frameOptions().disable() // h2-console 화면사용위해 해당 옵션들을 disable
                .and()
                .authorizeRequests() //URL별 권한관리 (authorizeRequests 있어야 antMatchers 사용 가능)
                .antMatchers("/", "/css/**", "/images/**", "/js/**", "/h2-console/**").permitAll() // 전체 열람 가능
                .antMatchers("/api/v1/**").hasRole(Role.USER.name()) //USER 권한 가진사람만 가능
                .anyRequest().authenticated() // 이외 URL은 인증된 사용자(로그인한 사용자)만 사용가능
                .and()
                .logout().logoutSuccessUrl("/") // 로그아웃시 "/"로 이동
                .and()
                .oauth2Login() //OAuth2 로그인 관련설정 나온다고 알려줌
                .userInfoEndpoint() // 로그인 성공후 정보가져올때 설정 담당
                .userService(customOAuth2UserService); //로그인시 UserService 인터페이스 구현체를 등록


    }
}
