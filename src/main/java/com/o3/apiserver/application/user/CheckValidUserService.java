package com.o3.apiserver.application.user;

import com.o3.apiserver.application.user.dto.SignUpUserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class CheckValidUserService {

    private final PasswordEncoder passwordEncoder;

    public void isPermit(SignUpUserDto signUpUserDto) {

//        for (PermitUserType value : PermitUserType.values()) {
//            value.isPermitUser(signUpUserDto, value);
//        }
    }

    public void checkPassword(String prevPassword, String postPassword) {
        if (!passwordEncoder.matches(prevPassword, postPassword)) {
            throw new IllegalArgumentException("비밀번호가 다릅니다");
        }
    }
}
