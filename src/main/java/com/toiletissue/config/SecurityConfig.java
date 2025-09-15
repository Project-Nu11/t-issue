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
                                "/member/login", "/member/fail", "/member/register",
                                "/main", "/error", "/toilet/subway",
                                "/css/**","/js/**","/images/**","/webjars/**"
                        ).permitAll()
                        .requestMatchers("/member/list","/member/select","/member/mypage").hasAuthority("ROLE_USER")
                        .anyRequest().permitAll()
                )
                .formLogin(form -> form
                        .loginPage("/member/login")
                        .loginProcessingUrl("/member/login")  // POST: 스프링 시큐리티가 처리 (컨트롤러 X)
                        .usernameParameter("memberId")
                        .passwordParameter("memberPwd")
                        .defaultSuccessUrl("/main", true)
                        .failureUrl("/member/fail?message=로그인에%20실패했습니다")
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/main")
                        .deleteCookies("JSESSIONID")
                        .invalidateHttpSession(true)
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
