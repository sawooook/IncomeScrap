package com.o3.apiserver.application.scrap.port;

import com.o3.apiserver.infrastructure.thirdparty.adapter.dto.GetThirdPartyScrapDto;

import java.io.IOException;

public interface ThirdPartyDrivenPort {
    void getScrap(GetThirdPartyScrapDto scrapDto) throws IOException;
}
