package com.o3.apiserver.controller.scrap;

import com.o3.apiserver.application.scrap.CalculateRefundScrapService;
import com.o3.apiserver.application.scrap.GetScrapService;
import com.o3.apiserver.application.scrap.dto.GetTotalRefundDto;
import com.o3.apiserver.common.CommonResponse;
import com.o3.apiserver.common.dto.LoginAuthUserDto;
import com.o3.apiserver.controller.scrap.response.GetTotalRefundResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/szs")
@RequiredArgsConstructor
public class ScrapController {

    private final GetScrapService getScrapService;
    private final CalculateRefundScrapService calculateRefundScrapService;

    @PostMapping("/scrap")
    public ResponseEntity<CommonResponse<?>> getScrap(@AuthenticationPrincipal LoginAuthUserDto loginAuthUserDto) throws IOException {
        getScrapService.getScrap(loginAuthUserDto);
        return ResponseEntity.ok().body(CommonResponse.success());
    }

    @PostMapping("/refund")
    public ResponseEntity<CommonResponse<GetTotalRefundResponse>> getCalculateRefund(@AuthenticationPrincipal LoginAuthUserDto loginAuthUserDto) {
        GetTotalRefundDto result = calculateRefundScrapService.getByUserUniqueId(loginAuthUserDto);

        System.out.println("result = " + result.toString());

        return ResponseEntity.ok().body(CommonResponse.convert(GetTotalRefundResponse.convert(result)));
    }
}
