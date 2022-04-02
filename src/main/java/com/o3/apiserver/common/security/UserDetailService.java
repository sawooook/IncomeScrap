package com.o3.apiserver.common.security;

import com.o3.apiserver.application.user.UserInterface;
import com.o3.apiserver.common.dto.LoginUserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserDetailService implements UserDetailsService {

    private final UserInterface userInterface;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        userInterface.findNullableById()

        LoginUserDto.create()
    }
}
