package com.o3.apiserver.common.security;

import com.o3.apiserver.application.user.UserInterface;
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

    private final UserInterface userInterface;

    @Override
    public UserDetails loadUserByUsername(String userUniqueId) throws UsernameNotFoundException {
        User user = userInterface.findByUserUniqueId(userUniqueId);
        return LoginAuthUserDto.create(user);
    }
}
