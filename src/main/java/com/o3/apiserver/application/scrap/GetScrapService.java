package com.o3.apiserver.application.scrap;

import com.o3.apiserver.application.scrap.port.ThirdPartyDrivenPort;
import com.o3.apiserver.common.dto.LoginAuthUserDto;
import com.o3.apiserver.infrastructure.thirdparty.adapter.dto.GetThirdPartyScrapDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class GetScrapService {
    private final ThirdPartyDrivenPort thirdPartyDrivenPort;


    public void getScrap(LoginAuthUserDto loginAuthUserDto) {
        thirdPartyDrivenPort.getScrap(
                new GetThirdPartyScrapDto(loginAuthUserDto.getName(), loginAuthUserDto.getRegisterNumber())
        );
    }
}
