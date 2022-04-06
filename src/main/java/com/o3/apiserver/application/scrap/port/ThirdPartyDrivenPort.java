package com.o3.apiserver.application.scrap.port;

import com.o3.apiserver.infrastructure.thirdparty.adapter.dto.GetThirdPartyScrapDto;

public interface ThirdPartyDrivenPort {
    void getScrap(GetThirdPartyScrapDto scrapDto);
}
