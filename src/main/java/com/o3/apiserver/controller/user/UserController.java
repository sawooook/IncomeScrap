package com.o3.apiserver.presenter;


import com.o3.apiserver.application.user.LoginUserService;
import com.o3.apiserver.application.user.SignUpUserService;
import com.o3.apiserver.common.CommonResponse;
import com.o3.apiserver.common.dto.LoginAuthUserDto;
import com.o3.apiserver.presenter.request.LoginUserRequest;
import com.o3.apiserver.presenter.request.SignUpUserRequest;
import com.o3.apiserver.presenter.response.LoginUserResponse;
import com.o3.apiserver.presenter.response.MyInfoUserResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/szs")
public class UserController {

    private final LoginUserService loginUserService;
    private final SignUpUserService signUpUserService;

    public UserController(LoginUserService loginUserService, SignUpUserService signUpUserService) {
        this.loginUserService = loginUserService;
        this.signUpUserService = signUpUserService;
    }

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
        String token = loginUserService.get(request.convertDto());

        return ResponseEntity.ok().body(CommonResponse.convert(new LoginUserResponse(token)));
    }

    @PostMapping("/me")
    public ResponseEntity<CommonResponse<MyInfoUserResponse>> login(
            @AuthenticationPrincipal LoginAuthUserDto loginAuthUserDto
    ) {
        return ResponseEntity.ok().body(CommonResponse.convert(MyInfoUserResponse.convert(loginAuthUserDto)));
    }
}
