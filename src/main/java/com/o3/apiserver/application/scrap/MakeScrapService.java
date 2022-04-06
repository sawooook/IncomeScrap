package com.o3.apiserver.application.scrap;

import com.o3.apiserver.application.scrap.port.ScrapDrivenPort;
import com.o3.apiserver.application.scrap.port.ScrapPayDetailDrivenPort;
import com.o3.apiserver.application.scrap.port.ScrapTaxDetailDrivenPort;
import com.o3.apiserver.application.user.port.UserDrivenPort;
import com.o3.apiserver.domain.scrap.Scrap;
import com.o3.apiserver.domain.scrap.ScrapPayDetail;
import com.o3.apiserver.domain.scrap.ScrapTaxDetail;
import com.o3.apiserver.domain.user.User;
import com.o3.apiserver.infrastructure.thirdparty.external.response.ThirdPartyPayDetailResponse;
import com.o3.apiserver.infrastructure.thirdparty.external.response.ThirdPartyResponse;
import com.o3.apiserver.infrastructure.thirdparty.external.response.ThirdPartyTaxDetailResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class MakeScrapService {

    private final ScrapDrivenPort scrapDrivenPort;
    private final UserDrivenPort userDrivenPort;
    private final ScrapTaxDetailDrivenPort scrapTaxDetailDrivenPort;
    private final ScrapPayDetailDrivenPort scrapPayDetailDrivenPort;


    public void make(ThirdPartyResponse response) {
        User user = userDrivenPort.findByUserUniqueId(response.getResponse().getUserId());
        Scrap makeScrap = scrapDrivenPort.save(Scrap.create(response, user));


        for (ThirdPartyTaxDetailResponse taxDetail : response.getResponse().getTaxDetailResponse()) {
            ScrapTaxDetail scrapTaxDetail = ScrapTaxDetail.create(makeScrap, taxDetail);
            scrapTaxDetailDrivenPort.save(scrapTaxDetail);
        }

        for (ThirdPartyPayDetailResponse payDetail : response.getResponse().getPayDetailResponse()) {
            ScrapPayDetail scrapPayDetail = ScrapPayDetail.create(makeScrap, payDetail);
            scrapPayDetailDrivenPort.save(scrapPayDetail);
        }
    }
}
