package com.toiletissue.config;

import com.toiletissue.common.MemberRole;
import com.toiletissue.config.handler.AuthFailHandler;
import com.sun.source.tree.ReturnTree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private AuthFailHandler authFailHandler;

    @Bean
    public PasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder();
    }

    /* 정적리소스에 대한 요청을 제외하겠다는 설정 static 파일 하위 */
    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {

        return web -> web.ignoring()
                .requestMatchers(PathRequest.toStaticResources().atCommonLocations());
    }

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        /* 요청에 대한 권한 체크 */
        http.authorizeHttpRequests( auth -> {
            auth.requestMatchers( "/auth/login","/member/signup", "/auth/fail", "/", "/main","/notice/manager","/manager/*","/toilet/*","/*/manager","/timer","/*/manager/*","/notice/manager/update").permitAll();            auth.requestMatchers("/manager/*","*/manager").hasAnyAuthority(MemberRole.manager.getRole());
            auth.requestMatchers("/member/*").hasAnyAuthority(MemberRole.member.getRole());
            auth.anyRequest().authenticated();

        }).formLogin( login -> {
            login.loginPage("/auth/login");
            login.usernameParameter("memberId");
            login.passwordParameter("memberPwd");
            login.defaultSuccessUrl("/", true);
            login.failureHandler(authFailHandler);

        }).logout( logout -> {
            logout.logoutUrl("/auth/logout");
            logout.deleteCookies("JSESSIONID");
            logout.invalidateHttpSession(true);
            logout.logoutSuccessUrl("/");

        }).sessionManagement( session -> {
            session.maximumSessions(1);
            session.invalidSessionUrl("/");

        }).csrf( csrf -> csrf.disable());

        return http.build();
    }
}

