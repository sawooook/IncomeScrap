package com.o3.apiserver.application.user;

import com.o3.apiserver.application.user.dto.SignUpUserDto;
import com.o3.apiserver.application.user.port.UserDrivenPort;
import com.o3.apiserver.common.exception.NotRegisterUserException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import static com.o3.apiserver.util.CommonTestUtil.makeSignUpDto;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SignUpUserServiceTest {

    @Mock
    private UserDrivenPort userDrivenPort;

    @Mock
    private CheckValidUserService checkValidUserService;

    @InjectMocks
    private SignUpUserService signUpUserService;

    @Spy
    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();


    @Test
    @DisplayName("회원가입에 성공한다 - O")
    void signUpSuccess() {
        SignUpUserDto signUpUserDto = makeSignUpDto();

        signUpUserService.get(signUpUserDto);

        verify(checkValidUserService, times(1)).isPermit(any());
        verify(userDrivenPort, times(1)).isAlreadyRegister(any());
        verify(userDrivenPort, times(1)).save(any());
        verify(passwordEncoder, times(1)).encode(any());
    }

    @Test
    @DisplayName("허용 불가능한 유저라 회원가입에 실패한다 - X")
    void signUpFailNotPermit() {
        doThrow(new NotRegisterUserException())
                .when(checkValidUserService).isPermit(any());

        assertThrows(NotRegisterUserException.class, () -> {
            signUpUserService.get(any());
        });

        verify(checkValidUserService, times(1)).isPermit(any());
        verify(userDrivenPort, times(0)).isAlreadyRegister(any());
        verify(userDrivenPort, times(0)).save(any());
        verify(passwordEncoder, times(0)).encode(any());
    }
}