package com.o3.apiserver.common.security;

import com.o3.apiserver.application.user.port.UserDrivenPort;
import com.o3.apiserver.common.dto.LoginAuthUserDto;
import com.o3.apiserver.domain.user.User;
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

    private final UserDrivenPort userDrivenPort;

    @Override
    public UserDetails loadUserByUsername(String userUniqueId) throws UsernameNotFoundException {
        User user = userDrivenPort.findByUserUniqueId(userUniqueId);
        LoginAuthUserDto loginAuthUserDto = LoginAuthUserDto.create(user);
//        loginAuthUserDto.getR
        return LoginAuthUserDto.create(user);
    }
}
