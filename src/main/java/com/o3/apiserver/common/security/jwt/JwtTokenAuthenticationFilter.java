package com.o3.apiserver.common.security.jwt;

import com.o3.apiserver.common.dto.LoginAuthUserDto;
import com.o3.apiserver.common.security.UserDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtTokenAuthenticationFilter extends OncePerRequestFilter {

    private final JwtTokenProvider jwtTokenProvider;
    private final UserDetailService userDetailService;

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws ServletException, IOException {
        logger.info("[get Request] method : " + request.getMethod() + " URI : " + request.getRequestURI());
        String token = jwtTokenProvider.getTokenByHeader(request);

        if (jwtTokenProvider.isValidToken(token)) {
            String tokenResult = jwtTokenProvider.getReplaceToken(token);
            String uniqueUserId = jwtTokenProvider.getUniqueUserId(tokenResult);
            LoginAuthUserDto loginUser = (LoginAuthUserDto) userDetailService.loadUserByUsername(uniqueUserId);


            SecurityContextHolder.getContext().setAuthentication(
                    new UsernamePasswordAuthenticationToken(loginUser, "")
            );
        }

        filterChain.doFilter(request, response);
    }
}
