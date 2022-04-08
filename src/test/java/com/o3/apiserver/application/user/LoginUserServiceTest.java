package com.o3.apiserver.application.user;

import com.o3.apiserver.application.user.dto.LoginUserDto;
import com.o3.apiserver.application.user.port.UserDrivenPort;
import com.o3.apiserver.common.exception.NotFoundDataException;
import com.o3.apiserver.common.security.jwt.JwtTokenProvider;
import com.o3.apiserver.domain.user.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static com.o3.apiserver.util.CommonTestUtil.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class LoginUserServiceTest {

    @Mock
    private UserDrivenPort userDrivenPort;

    @Mock
    private JwtTokenProvider jwtTokenProvider;

    @Mock
    private CheckValidUserService checkValidUserService;

    @InjectMocks
    private LoginUserService loginUserService;

    @Test
    @DisplayName("정상적으로 로그인에 성공하면 토큰을 return 해준다 - O")
    void successLogin() {
        LoginUserDto userDto = makeLoginUserDto();

        LocalDateTime makeTime = LocalDateTime.of(2021, 5, 5, 5, 5, 5);
        User user = makeUser();

        when(userDrivenPort.findByUserUniqueId(any()))
                .thenReturn(user);
        when(jwtTokenProvider.generateToken(any(), any()))
                .thenReturn(makeToken);

        String token = loginUserService.login(userDto, makeTime);

        verify(userDrivenPort, times(1)).findByUserUniqueId(anyString());
        verify(checkValidUserService, times(1)).checkPassword(anyString(), anyString());

        assertEquals(token, makeToken);
    }

    @Test
    @DisplayName("등록되지 않은 유저일 경우 예외가 발생한다 - X")
    void notFoundUserException() {
        LoginUserDto userDto = makeLoginUserDto();

        when(userDrivenPort.findByUserUniqueId(any()))
                .thenThrow(NotFoundDataException.class);

        assertThrows(NotFoundDataException.class, () -> {
            loginUserService.login(userDto, LocalDateTime.of(2021, 5, 5, 5, 5, 5));
        });
    }
}