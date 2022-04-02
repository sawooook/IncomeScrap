package com.o3.apiserver.application.user;

import com.o3.apiserver.application.user.dto.SignUpUserDto;
import org.springframework.stereotype.Service;

@Service
public class CheckValidUserService {

    public void isPermit(SignUpUserDto signUpUserDto) {

//        for (PermitUserType value : PermitUserType.values()) {
//            value.isPermitUser(signUpUserDto, value);
//        }
    }
}
