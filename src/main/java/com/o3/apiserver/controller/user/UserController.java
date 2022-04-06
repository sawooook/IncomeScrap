package com.o3.apiserver.controller.user;


import com.o3.apiserver.application.user.LoginUserService;
import com.o3.apiserver.application.user.SignUpUserService;
import com.o3.apiserver.common.CommonResponse;
import com.o3.apiserver.common.dto.LoginAuthUserDto;
import com.o3.apiserver.controller.user.request.LoginUserRequest;
import com.o3.apiserver.controller.user.request.SignUpUserRequest;
import com.o3.apiserver.controller.user.response.LoginUserResponse;
import com.o3.apiserver.controller.user.response.MyInfoUserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/szs")
@RequiredArgsConstructor
public class UserController {

    private final LoginUserService loginUserService;
    private final SignUpUserService signUpUserService;

    @PostMapping("/signup")
    public ResponseEntity<CommonResponse<?>> signUp(
            @RequestBody SignUpUserRequest request
    ) {
        signUpUserService.get(request.convertDto());
        return ResponseEntity.ok().body(CommonResponse.success());
    }

    @PostMapping("/login")
    public ResponseEntity<CommonResponse<LoginUserResponse>> login(
            @RequestBody LoginUserRequest request
    ) {
        String token = loginUserService.login(request.convertDto());

        return ResponseEntity.ok().body(CommonResponse.convert(new LoginUserResponse(token)));
    }

    @PostMapping("/me")
    public ResponseEntity<CommonResponse<MyInfoUserResponse>> login(
            @AuthenticationPrincipal LoginAuthUserDto loginAuthUserDto
    ) {
        return ResponseEntity.ok().body(CommonResponse.convert(MyInfoUserResponse.convert(loginAuthUserDto)));
    }
}
