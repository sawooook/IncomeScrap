package com.o3.apiserver.common.security;

import com.o3.apiserver.common.security.jwt.JwtTokenAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final AuthenticationExceptionHandler authenticationExceptionHandler;
    private final JwtTokenAuthenticationFilter jwtTokenAuthenticationFilter;

    private static final String[] PERMIT_URL = {
            "/szs/signup",
            "/szs/login",

            // swagger
            "/v2/api-docs",
            "**/configuration/ui",
            "/swagger-resources",
            "/swagger-resources/**",
            "**/configuration/security",
            "/swagger-ui.html", "/webjars/**", "/swagger/**"
    };

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .cors().disable()
                .httpBasic().disable()
                .authorizeRequests()
                .antMatchers(PERMIT_URL)
                .permitAll()
                .anyRequest().authenticated().and()
                .exceptionHandling().authenticationEntryPoint(authenticationExceptionHandler)
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .httpBasic().authenticationEntryPoint(authenticationExceptionHandler)
                .and()
                .addFilterBefore(jwtTokenAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

    }

//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        web.ignoring()
//                .antMatchers(
//                        "/favicon.ico"
//                        , "/error"
//                        , "/swagger-ui/**"
//                        , "/swagger-resources/**"
//                        , "/v3/api-docs"
//                );
//
//    }
}
