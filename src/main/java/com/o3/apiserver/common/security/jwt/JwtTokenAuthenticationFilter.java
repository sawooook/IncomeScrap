package com.o3.apiserver.common.security.jwt;

import com.o3.apiserver.common.dto.LoginAuthUserDto;
import com.o3.apiserver.common.security.UserDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

@Component
@RequiredArgsConstructor
public class JwtTokenAuthenticationFilter extends OncePerRequestFilter {

    private final JwtTokenProvider jwtTokenProvider;
    private final UserDetailService userDetailService;
    private static final String[] PERMIT_URL = {"/szs/signup", "/szs/login"};

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws ServletException, IOException {
        logger.info("[process Request] method : " + request.getMethod() + " URI : " + request.getRequestURI());
        String token = jwtTokenProvider.getTokenByHeader(request);

        if (jwtTokenProvider.isValidToken(token)) {
            String replaceToken = jwtTokenProvider.getReplaceToken(token);
            String userUniqueId = jwtTokenProvider.getUserUniqueId(replaceToken);

            LoginAuthUserDto loginAuthUserDto = (LoginAuthUserDto) userDetailService.loadUserByUsername(userUniqueId);

            SecurityContextHolder.getContext().setAuthentication(
                    new UsernamePasswordAuthenticationToken(loginAuthUserDto, "", loginAuthUserDto.getAuthorities())
            );
        }

        filterChain.doFilter(request, response);
    }
}
