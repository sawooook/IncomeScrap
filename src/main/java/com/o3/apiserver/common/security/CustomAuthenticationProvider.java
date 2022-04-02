package com.o3.apiserver.common.security;

import com.o3.apiserver.application.user.CheckValidUserService;
import com.o3.apiserver.common.dto.LoginAuthUserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class CustomAuthenticationProvider implements AuthenticationProvider {
    private final UserDetailsService userDetailsService;
    private final CheckValidUserService checkValidUserService;


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String name = authentication.getName().toLowerCase();
        String passWord = String.valueOf(authentication.getCredentials()).toLowerCase();
        LoginAuthUserDto loginAuthUserDto = (LoginAuthUserDto) userDetailsService.loadUserByUsername(name);

        // 비밀번호 체크
        checkValidUserService.checkPassword(passWord, loginAuthUserDto.getPassword());

        return new UsernamePasswordAuthenticationToken(loginAuthUserDto, "");
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication == UsernamePasswordAuthenticationToken.class;
    }
}
