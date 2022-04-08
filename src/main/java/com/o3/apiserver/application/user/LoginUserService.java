package com.o3.apiserver.application.user;

import com.o3.apiserver.application.user.dto.LoginUserDto;
import com.o3.apiserver.application.user.port.UserDrivenPort;
import com.o3.apiserver.common.security.jwt.JwtTokenProvider;
import com.o3.apiserver.domain.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@Transactional
@RequiredArgsConstructor
public class LoginUserService {

    private final UserDrivenPort userDrivenPort;
    private final JwtTokenProvider jwtTokenProvider;
    private final CheckValidUserService checkValidUserService;


    public String login(LoginUserDto loginUserDto, LocalDateTime now) {
        String uniqueId = loginUserDto.getUserUniqueId().toLowerCase();
        String password = loginUserDto.getPassword().toLowerCase();

        User findUser = userDrivenPort.findByUserUniqueId(uniqueId);

        // 비밀번호 체크
        checkValidUserService.checkPassword(password, findUser.getPassword());

        return jwtTokenProvider.generateToken(findUser.getUserUniqueId(), now);
    }
}
