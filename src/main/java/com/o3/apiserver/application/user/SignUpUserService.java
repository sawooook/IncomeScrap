package com.o3.apiserver.application.user;

import com.o3.apiserver.application.user.dto.SignUpUserDto;
import com.o3.apiserver.application.user.port.UserDrivenPort;
import com.o3.apiserver.domain.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class SignUpUserService {

    private final UserDrivenPort userDrivenPort;
    private final CheckValidUserService checkValidUserService;
    private final PasswordEncoder passwordEncoder;


    public void get(SignUpUserDto signUpUserDto) {
        // 허용가능한 유저인지 체크
        checkValidUserService.isPermit(signUpUserDto);

        // 중복 체크
        userDrivenPort.isAlreadyRegister(signUpUserDto.getUserUniqueId());

        // 회원가입
        userDrivenPort.save(
                User.create(signUpUserDto, passwordEncoder.encode(signUpUserDto.getPassword()))
        );
    }
}
