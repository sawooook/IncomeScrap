package com.o3.apiserver.common.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.o3.apiserver.common.CommonResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.o3.apiserver.common.dto.ErrorResponseCodeType.UNAUTHORIZED;

@Component
@RequiredArgsConstructor
public class AuthenticationExceptionHandler implements AuthenticationEntryPoint {

    private final ObjectMapper objectMapper;

    @Override
    public void commence(
            HttpServletRequest request,
            HttpServletResponse response,
            AuthenticationException authException
    ) throws IOException {

        System.out.println("authException = " + authException.getMessage());

        String json = objectMapper.writeValueAsString(CommonResponse.error(UNAUTHORIZED.getCode()));
        response.setHeader("Content-Type", "application/json;charset=UTF-8");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.getWriter().write(json);
        response.getWriter().flush();
    }
}
