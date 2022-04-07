package com.o3.apiserver.application.user;

import com.o3.apiserver.application.user.dto.SignUpUserDto;
import com.o3.apiserver.application.user.dto.enums.PermitUserType;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class CheckValidUserService {

    private final PasswordEncoder passwordEncoder;

    /**
     * 회원가입이 불가능한 유저일 경우 예외발생
     */
    public void isPermit(SignUpUserDto signUpUserDto) {
        for (PermitUserType userType : PermitUserType.values()) {
            if (userType.isPermit(signUpUserDto)) {
                return;
            }
        }

        throw new IllegalArgumentException("회원가입 할 수 없는 유저입니다");
    }

    public void checkPassword(String prevPassword, String postPassword) {
        if (!passwordEncoder.matches(prevPassword, postPassword)) {
            throw new IllegalArgumentException("비밀번호가 다릅니다");
        }
    }
}
