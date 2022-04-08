package com.o3.apiserver.application.user;

import com.o3.apiserver.application.user.dto.SignUpUserDto;
import com.o3.apiserver.common.exception.NotMatchPasswordException;
import com.o3.apiserver.common.exception.NotRegisterUserException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CheckValidUserServiceTest {


    @Spy
    @InjectMocks
    private CheckValidUserService checkValidUserService;

    @Spy
    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Test
    @DisplayName("회원가입이 가능한 불가능한 유저일 경우 예외를 리턴한다 - X")
    void failRegister() {
        SignUpUserDto signUpDto = new SignUpUserDto("1", "123", "홍길동", "860824-1655069");
        assertThrows(NotRegisterUserException.class, () -> {
            checkValidUserService.isPermit(signUpDto);
        });
    }

    @Test
    @DisplayName("홍길동이란 아이디로 회원가입이 가능하다 - O")
    void successRegister() {
        SignUpUserDto signUpDto = new SignUpUserDto("1", "123", "홍길동", "860824-1655068");
        checkValidUserService.isPermit(signUpDto);
        verify(checkValidUserService, atLeast(1)).isPermit(signUpDto);
    }

    @Test
    @DisplayName("패스워드가 일치 - O")
    void passwordCorrect() {
        String prevPassword = "test1234";
        String postPassword = "$2a$10$PyL.9gRsMmDSMxoAhTnGz.od06XbrKJxYjupyslopK16a1QqxTnD6";

        checkValidUserService.checkPassword(prevPassword, postPassword);

        verify(checkValidUserService, times(1)).checkPassword(prevPassword, postPassword);
    }

    @Test
    @DisplayName("패스워드가 불일치 하여 예외 발생 - X")
    void passwordInCorrect() {
        String prevPassword = "errorPassword";
        String postPassword = "$2a$10$PyL.9gRsMmDSMxoAhTnGz.od06XbrKJxYjupyslopK16a1QqxTnD6";

        assertThrows(NotMatchPasswordException.class, () -> {
            checkValidUserService.checkPassword(prevPassword, postPassword);
        });
    }
}