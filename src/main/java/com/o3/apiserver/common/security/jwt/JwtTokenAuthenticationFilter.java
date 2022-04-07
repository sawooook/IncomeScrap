package com.o3.apiserver.common.security.jwt;

import lombok.RequiredArgsConstructor;
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
    private static final String[] PERMIT_URL = {"/szs/signup", "/szs/login"};

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws ServletException, IOException {
        logger.info("[process Request] method : " + request.getMethod() + " URI : " + request.getRequestURI());

        boolean result =
                Arrays.stream(PERMIT_URL).anyMatch(target -> request.getRequestURI().equals(target));

        if (result) {
            filterChain.doFilter(request, response);
            return;
        }


        String token = jwtTokenProvider.getTokenByHeader(request);

        if (!jwtTokenProvider.isValidToken(token)) {
            return;
        }

        filterChain.doFilter(request, response);
    }
}
