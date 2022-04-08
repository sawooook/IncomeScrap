package com.o3.apiserver.controller.scrap;

import com.o3.apiserver.application.scrap.CalculateRefundScrapService;
import com.o3.apiserver.application.scrap.GetScrapService;
import com.o3.apiserver.application.scrap.dto.GetTotalRefundDto;
import com.o3.apiserver.common.CommonResponse;
import com.o3.apiserver.common.dto.LoginAuthUserDto;
import com.o3.apiserver.controller.scrap.response.GetTotalRefundResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/szs")
@RequiredArgsConstructor
@Api(tags = "스크랩 정보를 제공하는 API")
public class ScrapController {

    private final GetScrapService getScrapService;
    private final CalculateRefundScrapService calculateRefundScrapService;

    @ApiOperation("환급정보 스크랩")
    @PostMapping("/scrap")
    public ResponseEntity<CommonResponse<?>> getScrap(@AuthenticationPrincipal LoginAuthUserDto loginAuthUserDto) {
        getScrapService.getScrap(loginAuthUserDto);
        return ResponseEntity.ok().body(CommonResponse.success());
    }

    @ApiOperation("환급액 구하기")
    @PostMapping("/refund")
    public ResponseEntity<CommonResponse<GetTotalRefundResponse>> getCalculateRefund(@AuthenticationPrincipal LoginAuthUserDto loginAuthUserDto) {
        GetTotalRefundDto result = calculateRefundScrapService.getByUserUniqueId(loginAuthUserDto);
        return ResponseEntity.ok().body(CommonResponse.convert(GetTotalRefundResponse.convert(result)));
    }
}
