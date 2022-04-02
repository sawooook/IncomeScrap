package com.o3.apiserver.presenter;


import com.o3.apiserver.application.user.LoginUserService;
import com.o3.apiserver.application.user.SignUpUserService;
import com.o3.apiserver.presenter.request.SignUpUserRequest;
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
    public void signUp(@RequestBody SignUpUserRequest request) {
        signUpUserService.signUp(request.convertDto());

    }

    @PostMapping("/login")
    public void login() {

//        CommonResponse.success()
    }
}
