package com.o3.apiserver.infrastructure.thirdparty.adapter.dto;

import com.o3.apiserver.common.dto.LoginAuthUserDto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class GetThirdPartyScrapDto {
    private final String name;
    private final String registerNumber;

    public static GetThirdPartyScrapDto convert(LoginAuthUserDto loginAuthUserDto) {
        return new GetThirdPartyScrapDto(loginAuthUserDto.getName(), loginAuthUserDto.getRegisterNumber());
    }
}
