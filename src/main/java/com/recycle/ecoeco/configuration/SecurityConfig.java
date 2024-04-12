package com.recycle.ecoeco.configuration;

import com.recycle.ecoeco.common.UserRole;
import com.recycle.ecoeco.configuration.handler.AuthFailHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private AuthFailHandler authFailHandler;

    @Autowired
    public SecurityConfig(AuthFailHandler authFailHandler) {
        this.authFailHandler = authFailHandler;
    }

    /* 비밀번호 암호화에 사용할 객체 BCryptPasswordEncoder bean 등록 */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /* 정적 리소스에 대한 요청은 제외하는 설정 */
    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return web -> web.ignoring()
                .requestMatchers(PathRequest.toStaticResources().atCommonLocations());
    }


    public void configure(WebSecurity web) throws Exception {
        web.ignoring().requestMatchers(PathRequest.toStaticResources().atCommonLocations());
    }

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        /* 요청에 대한 권한 체크 */
        http.authorizeHttpRequests( auth -> {
            auth.requestMatchers("/auth/login", "/user/signup", "/auth/fail", "/", "/main").permitAll();
//            auth.requestMatchers("/manager/*").hasAnyAuthority(UserRole.ADMIN.getRole());
//            auth.requestMatchers("/user/*").hasAnyAuthority(UserRole.USER.getRole());
            auth.requestMatchers("/auth/*", "/common/*","/configuration/*","/manager/*", "/user/*").permitAll();
//            auth.anyRequest().authenticated();
            auth.anyRequest().permitAll();
                }).formLogin( login -> {
                    login.loginPage("/auth/login");
                    login.usernameParameter("user");
                    login.passwordParameter("pass");
                    login.defaultSuccessUrl("/", true);
                    login.failureHandler(authFailHandler);
                }).logout( logout -> {
                    logout.logoutRequestMatcher(new AntPathRequestMatcher("/auth/logout"));
                    logout.deleteCookies("JSESSIONID");
                    logout.invalidateHttpSession(true);
                    logout.logoutSuccessUrl("/");
                }).sessionManagement( session -> {
                    session.maximumSessions(1);
                    session.invalidSessionUrl("/");
                })
                .csrf(csrf -> csrf.disable());

        return http.build();
    }

}
