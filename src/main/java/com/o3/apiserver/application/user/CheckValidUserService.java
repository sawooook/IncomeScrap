package com.o3.apiserver.application.user;

import com.o3.apiserver.application.user.dto.SignUpUserDto;
import com.o3.apiserver.application.user.dto.enums.PermitUserType;
import com.o3.apiserver.common.exception.NotMatchPasswordException;
import com.o3.apiserver.common.exception.NotRegisterUserException;
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

        throw new NotRegisterUserException();
    }

    public void checkPassword(String prevPassword, String hashPassword) {
        if (!passwordEncoder.matches(prevPassword, hashPassword)) {
            throw new NotMatchPasswordException();
        }
    }
}
