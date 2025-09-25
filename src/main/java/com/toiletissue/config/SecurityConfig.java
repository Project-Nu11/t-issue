package com.toiletissue.config;

import com.toiletissue.member.model.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    private final MemberService memberService;

    public SecurityConfig(@Lazy MemberService memberService) {
        this.memberService = memberService;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        var authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(memberService);
        authProvider.setPasswordEncoder(passwordEncoder());
        http.authenticationProvider(authProvider);

        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(
                                "/member/login", "/member/fail", "/member/register","/member/register/check-id",
                                "/member/register/consent","/member/find","/member/id", "/member/pwd",
                                 "/error", "/toilet/subway","/mypage/request",
                                "/css/**","/js/**","/images/**","/webjars/**"
                        ).permitAll()
                        .requestMatchers("/mypage/**","mypage/select").hasAuthority("ROLE_USER")
                        .anyRequest().permitAll()
                )
                .formLogin(form -> form
                        .loginPage("/member/login")
                        .loginProcessingUrl("/member/login")  // POST: 스프링 시큐리티가 처리 (컨트롤러 X)
                        .usernameParameter("memberId")
                        .passwordParameter("memberPwd")
                        .successHandler((req, res, auth) -> {
                                    // 로그인 성공 → 로그인 페이지로 다시 보내서 alert 띄우기
                                    res.sendRedirect("/member/login?success");
                                })
//                        .defaultSuccessUrl("/main", true)
                        .failureUrl("/member/login?code=LOGIN_FAIL")
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutUrl("/member/logout")
                        .logoutSuccessUrl("/main")
                        .deleteCookies("JSESSIONID")
                        .invalidateHttpSession(true)
                        .permitAll()
                )
                .csrf(csrf -> csrf.disable()); // 개발 중이면 꺼야함

        return http.build();
    }


//    // AuthenticationProvider 빈 생성
//    @Bean
//    public DaoAuthenticationProvider authenticationProvider() {
//        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
//        authProvider.setUserDetailsService(userService);
//        authProvider.setPasswordEncoder(passwordEncoder());
//        return authProvider;
//    }
//
//    // AuthenticationManager 빈
//    @Bean
//    public AuthenticationManager authenticationManager(DaoAuthenticationProvider authProvider) {
//        return authentication -> authProvider.authenticate(authentication);
//    }


    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
