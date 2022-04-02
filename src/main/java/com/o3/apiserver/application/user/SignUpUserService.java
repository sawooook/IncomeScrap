package com.o3.apiserver.application.user;

import com.o3.apiserver.application.user.dto.SignUpUserDto;
import com.o3.apiserver.domain.user.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SignUpUserService {

    private final UserInterface userInterface;
    private final CheckValidUserService checkValidUserService;

    public SignUpUserService(UserInterface userInterface, CheckValidUserService checkValidUserService) {
        this.userInterface = userInterface;
        this.checkValidUserService = checkValidUserService;
    }


    public void signUp(SignUpUserDto signUpUserDto) {
        // 허용가능한 유저인지 체크
        checkValidUserService.isPermit(signUpUserDto);

        // 중복 체크
        userInterface.isAlreadyRegister(signUpUserDto.getUserUniqueId());

        // 회원가입
        userInterface.save(User.create(signUpUserDto));
    }
}
