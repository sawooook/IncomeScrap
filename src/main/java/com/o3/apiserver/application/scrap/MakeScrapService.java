package com.o3.apiserver.application.scrap;

import com.o3.apiserver.application.scrap.dto.GetScrapDto;
import com.o3.apiserver.application.scrap.dto.GetScrapPayDetailDto;
import com.o3.apiserver.application.scrap.dto.GetScrapTaxDetailDto;
import com.o3.apiserver.application.scrap.port.ScrapDrivenPort;
import com.o3.apiserver.application.scrap.port.ScrapPayDetailDrivenPort;
import com.o3.apiserver.application.scrap.port.ScrapTaxDetailDrivenPort;
import com.o3.apiserver.application.user.port.UserDrivenPort;
import com.o3.apiserver.domain.scrap.Scrap;
import com.o3.apiserver.domain.scrap.ScrapPayDetail;
import com.o3.apiserver.domain.scrap.ScrapTaxDetail;
import com.o3.apiserver.domain.user.User;
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


    public void make(GetScrapDto scrapDto) {
        User user = userDrivenPort.findByUserUniqueId(scrapDto.getResultResponse().getUserUniqueId());
        Scrap makeScrap = scrapDrivenPort.save(Scrap.create(scrapDto, user));

        for (GetScrapTaxDetailDto taxDetail : scrapDto.getResultResponse().getTaxDetailResponse()) {
            ScrapTaxDetail scrapTaxDetail = ScrapTaxDetail.create(makeScrap, taxDetail);
            scrapTaxDetailDrivenPort.save(scrapTaxDetail);
        }

        for (GetScrapPayDetailDto payDetail : scrapDto.getResultResponse().getPayDetailResponse()) {
            ScrapPayDetail scrapPayDetail = ScrapPayDetail.create(makeScrap, payDetail);
            scrapPayDetailDrivenPort.save(scrapPayDetail);
        }
    }
}
