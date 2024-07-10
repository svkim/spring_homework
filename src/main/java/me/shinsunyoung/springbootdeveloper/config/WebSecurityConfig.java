package me.shinsunyoung.springbootdeveloper.config;

import lombok.RequiredArgsConstructor;
import me.shinsunyoung.springbootdeveloper.service.UserDetailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.header.writers.frameoptions.XFrameOptionsHeaderWriter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.filter.HiddenHttpMethodFilter;

import java.util.Locale;

import static org.springframework.boot.autoconfigure.security.servlet.PathRequest.toH2Console;

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
public class WebSecurityConfig  {

    private final UserDetailService userService;


    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public WebSecurityCustomizer configure() {
        return (web) -> web.ignoring()
                .requestMatchers(toH2Console())
                .requestMatchers("/static/**", "/css/**", "/js/**", "/img/**");
    }


    @Bean
    public HiddenHttpMethodFilter hiddenHttpMethodFilter() {
        return new HiddenHttpMethodFilter();
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorizeRequests -> authorizeRequests
                        .requestMatchers("/login", "/join", "/user", "/main/main1",
                                "/customer/*", "/login/*", "/goods/*", "/pay/*", "/policy/*",
                                "/customerCenter/main", "/customerCenter/notice_1", "/main/home",
                                "/customerCenter/faq", "/customerCenter/board",
                                "/board/list", "/board/view", "/goods/detail", "/login/resetpassword",
                                "/mugunghwa/category", "/mugunghwa/detail/{id}", "/login/successresetpassword",
                                "users/*", "/users/{userId}", "/comment",
                                "/mugunghwa/tem", "/mugunghwa/{id}", "/mugunghwa/view").permitAll()
                        .requestMatchers("/board/write", "/board/writepro", "/board/delete",
                                "/board/modify/{boardId}", "/board/update/{boardId}", "/mypage/main",
                                "/users/modify", "/users/view", "/users/update", "/pay/*",
                                "/comments/{id}", "/mugunghwa/detail/{productId}/comment",
                                "/product/{productId}/user/{userId}", "/comment").hasRole("USER")
                        .requestMatchers("/*", "/*/*", "/admin/*", "/admin/AllUsers",
                                "/admin/IdUser", "/admin/userDelete", "/mugunghwa/adminregister", "/ad",
                                "/register", "/register/new").hasRole("ADMIN")
                        .anyRequest().authenticated())
                .formLogin(form -> form
                        .loginPage("/login")
                        .successHandler(new CustomSuccessHandler()))
                .logout(logout -> logout
                        .logoutSuccessUrl("/main/home")
                        .invalidateHttpSession(true))
                .csrf().disable();

        return http.build();
    }




    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http, BCryptPasswordEncoder bCryptPasswordEncoder, UserDetailService userDetailService) throws Exception {
        return http.getSharedObject(AuthenticationManagerBuilder.class)
                .userDetailsService(userService)
                .passwordEncoder(bCryptPasswordEncoder)
                .and()
                .build();
    }


    //비밀번호 변경
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
//    }


}
